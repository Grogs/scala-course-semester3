package fss

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.console

@JSExport
class App extends JSApp {

  @JSExport
  def main(): Unit = {
    console.log("Hello from Scala.js")
  }

}
