name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.5.0",
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.webjars" % "animate.css" % "3.5.2"

)


lazy val populateCatalogueCache = taskKey[Unit]("Populate conf/example-hotels with some PCS properties")

populateCatalogueCache := {
  import collection.JavaConverters._,org.jsoup.Jsoup,scala.io.Source,util.Try
  for {
    destinationId <- Seq("de549499", "de504261", "de550392", "de554288")
    hotelId <- Jsoup.connect(s"https://uk.hotels.com/$destinationId/").get.select("a[data-hotel-id]").asScala.map(_.attr("data-hotel-id"))
    _ = println(s"Retrieve JSON for $hotelId in $destinationId")
    pcsResp <- Try(Source.fromURL(s"http://hcom-pcs-stg.staging-hotels.com/property_catalogue_svc/v2/property/$hotelId").mkString).toOption
    path = (resourceDirectory in Compile).value / "example-hotels" / s"$hotelId.json"
    _ = println(s"Writing to $path")
  } IO.write(path, pcsResp)
}
