#Lesson 7

Start by checking out the `lesson7`branch

This week we want to allow the user to display the search results on a map.

Demo: https://limitless-lowlands-73789.herokuapp.com/hotels/search?destination=london&distance=1.5

##Step 1 Add button to create modal for the map
Start by adding a button which launches a bootstrap modal to contain the map.  

You can do this by fixing the tests in `services.hotels.Lesson7`.  

Please refer to the Bootstrap docs for modals: http://getbootstrap.com/javascript/#modals

##Step 2 Display a map in the modal
Next, you need to add a Google Map.

We can use access the JavaScript Google Maps in `App` in the client.
 
Steps:
* Add an event listener to the modal button
     http://getbootstrap.com/javascript/#modals-events
* In the event listener, call the backend to get the new set of hotels (as we introduced last week)
* Take the new hotels and draw them on a Google Map.
    * Start by adding a marker for each hotel.
    https://developers.google.com/maps/documentation/javascript/examples/marker-simple
    * Then add an info window to show the hotel's name and description.
