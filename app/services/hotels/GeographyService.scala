package services.hotels

import javax.inject.Singleton

import model.Coordinates

@Singleton
class GeographyService {

  def lookupDestination(name: String): Option[Coordinates] = {
    ???
  }

}