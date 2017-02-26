package services.hotels

import org.jsoup.Jsoup
import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class HotelsControllerSpec extends PlaySpec with OneAppPerTest {

  "HotelsController.search" should {

    "send 200 on valid request" in {
      route(app, FakeRequest(GET, "/hotels/london?distance=5")).map(status) mustBe Some(OK)
    }

    "include distance and destination in the title" in {
      val body = route(app, FakeRequest(GET, "/hotels/london?distance=5")).map(contentAsString).get
      val title = Jsoup.parse(body).select("title").html

      title must include ("london")
      title must (include ("5km") or include ("5 kilometers"))
    }

    "output the titles of the hotels found" in {
      val body = route(app, FakeRequest(GET, "/hotels/london?distance=1.2")).map(contentAsString).get

      body must include ("Park Plaza Westminster Bridge London")
      body must include ("Club Quarters, Trafalgar Square")
    }

    "send 400 on invalid distance" in {
      route(app, FakeRequest(GET, "/hotels/london?distance=-5")).map(status) mustBe Some(BAD_REQUEST)
      route(app, FakeRequest(GET, "/hotels/london?distance=-5")).map(contentAsString) mustBe Some("Invalid distance")
    }

  }

}
