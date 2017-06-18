# Lesson 5

Last week you started implementing a search results page. THis week, you have to further flesh out this page.

* Check out the `lesson5` branch 
* Fix the tests in `HotelsControllerSpec`.
    * You can check your progress by running `./sbt run` and then browsing to:
        * http://localhost:9000/hotels/search?destination=london&distance=1.2
    * You can run the tests on any file change by running this in the terminal:
        * `./sbt "~testOnly *.HotelsControllerSpec"`
    * You'll need to edit the `searchResults.scala.html` view
        * Docs for Play's templates: https://www.playframework.com/documentation/2.5.x/ScalaTemplates
