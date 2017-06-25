package fss

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

import autowire._
import org.scalajs.dom.html.{Button, Input}
import org.scalajs.dom.{Event, document}
import services.hotels.HotelsService

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

@JSExportTopLevel("App")
class App extends JSApp {

  def hotelsTables() = document.querySelector("table")
  def destination() = document.getElementById("destination").asInstanceOf[Input]
  def distance() = document.getElementById("distance").asInstanceOf[Input]
  def searchButton() = document.getElementById("load-hotels").asInstanceOf[Button]

  @JSExport
  def main(): Unit = {
    println("Hello from Scala.js")
    //This code runs when the page laods
  }

}


