package fss

import autowire._
import google.maps.InfoWindowOptions
import model.{Coordinates, Hotel}
import org.scalajs.dom.html.{Button, Input}
import org.scalajs.dom.{Element, Event, document}
import org.scalajs.jquery.{JQueryEventObject, jQuery}
import services.hotels.HotelsService

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("App")
class App extends JSApp {

  def hotelsTables() = document.querySelector("table")
  def destination() = document.getElementById("destination").asInstanceOf[Input]
  def distance() = document.getElementById("distance").asInstanceOf[Input]
  def searchButton() = document.getElementById("load-hotels").asInstanceOf[Button]

  @JSExport
  def main(): Unit = {


    new Autocomplete(
      document.getElementById("destination").asInstanceOf[Input],
      Seq("London", "Paris", "Bath"),
      _ => handleChange(null)
    )

    destination().onkeyup = handleChange _
    distance().onkeyup = handleChange _
    distance().onchange = handleChange _

    searchButton().style.display = "none"

    // From http://getbootstrap.com/javascript/#modals-events
    jQuery("#mapModal").on("shown.bs.modal",
      (_: JQueryEventObject) => {
        val dest = destination().value
        val dist = distance().value.toLong
        Client[HotelsService].search(dest, dist).call().foreach { hotels =>
          document.getElementById("mapModalLabel").innerHTML = s"Hotels within ${dist}km of $dest"
          renderMap(document.getElementById("map"), hotels)
        }
      }
    )
  }

  def handleChange(e: Event) = {
    reload(destination().value, distance().value.toDouble)
  }

  def reload(destination: String, distance: Double) = {
    for {
      hotels <- Client[HotelsService].search(destination, distance).call()
      table = views.html.hotelsTable(hotels).body
    } hotelsTables().outerHTML = table
  }

  def renderMap(target: Element, hotels: Seq[Hotel]) = {

    val opts = google.maps.MapOptions(
      center = new google.maps.LatLng(50, 0),
      zoom = 11
    )

    val gmap = new google.maps.Map(target, opts)
  }


}


