package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import services.hotels.HotelsService

@Singleton
class HotelsController @Inject()(hotelsService: HotelsService) extends Controller {

  def search(destination: String, radius: String) = Action {

    val distance = radius.toDouble

    if (distance > 0) {
      Ok(
        views.html.searchResults(
          destination, radius,
          hotelsService.search(destination, distance)
        )
      )
    } else {
      BadRequest("Invalid distance")
    }
  }

}
