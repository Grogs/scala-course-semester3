package services.hotels

import javax.inject.{Inject, Singleton}

import model.Coordinates

@Singleton
class HotelFinderService @Inject()(catalogueService: HotelCatalogueService) {

  def findHotels(near: Coordinates, radius: Double): Seq[Long] = {
    ???
  }

  def haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double = {
    ???
  }


}