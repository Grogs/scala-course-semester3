#Lesson 4

Start by checking out the `lesson4`branch

Last week you implemented `GeographyService` and `HotelFinderService`.  
Let's start by looking at how they can be implemented.

This week we want to compose those two services and build a page to search for hotels"
* Fix the tests in `HotelsServiceTest` by implementing HotelsService
* Now build a page to show search results by fixing the tests in `HotelsControllerSpec`
    * Hints:
        * We have a `HotelsController` with the `HotelsService` injected. You can add an endpoint here.
        * You will need to add a route in the `routes` file.
            * You can see an example of extracting a path parameter there:  
              `GET     /assets/*file               controllers.Assets.versioned(path="/public", file: Asset)`  
              If we called `/assets/picture.png`, then `picture.png` would be passed into the `file` parameter
            * You will also need to extract a query parameter. Here's an example:  
              Given the route `GET   /comments                     controllers.Application.comments(page: Int)`  
              If we called `/comments?page=1`, then `1` would be passed into the  `page` parameter
            * For more info, see docs: https://www.playframework.com/documentation/2.5.x/ScalaRouting
        * You will need to add a template in the `views` package.
