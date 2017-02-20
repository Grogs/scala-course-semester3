package services.hotels

import javax.inject.{Inject, Singleton}

import model.Coordinates

@Singleton
class HotelFinderService @Inject()(catalogueService: HotelCatalogueService) {

  def findHotels(near: Coordinates, radius: Double): Seq[Long] = {
    //Use your haversine function, and all the hotels which can be accessed via `catalogueService.hotels.values`
    ???
  }

  def haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double = {
    // You can use https://rosettacode.org/wiki/Haversine_formula#Scala
    ???
  }


}