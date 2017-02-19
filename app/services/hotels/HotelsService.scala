package services.hotels

import javax.inject.Inject

import model.Hotel

class HotelsService @Inject() (
                                catalogueService: HotelCatalogueService,
                                geographyService: GeographyService,
                                hotelFinderService: HotelFinderService) {

  def search(destination: String, radius: Double): Seq[Hotel] = {
    ???
  }

}