# Lesson 6

Start by checking out the `lesson6`branch and running `sbt compile`.
 
[//]: # (Review solutions to lesson 5. Look at the code moved to shared.)


### Exercise 1 - Interactive Search
1. Add event handlers to the destination and distance inputs.
    * add logging to verify...
2. Make them call the reload function with the new destination and distance
    * add logging to verify...
2. Implement to the render function, it should
    * Fetch the new search results using the Autowire `Client`
        * Use `Client[HotelsService]` to call methods on the HotelsService we implemented a few weeks ago. 
        * Autowire documentation: https://github.com/lihaoyi/autowire#minimal-example
    * Generate the new table HTML using the shared Twirl template.
    * Replace the previous table with the new table.
4. Remove the Search button, it's not needed anymore.

### Step 2 - Autocompletion of destinations
Take a look at `fss.Autocomplete` and hook it up to the destination input
* You'll need to edit the `apply` method in `views.HotelListingTable`
    * ScalaTags documentation: http://www.lihaoyi.com/scalatags/
    
### Extension
* Only update search results for valid destinations.  
    * At the moment, if you type in Paris, you get intermediate empty search results until you finish typing.  
    * Instead, don't update the results if it's empty.  
      Alternatively, show a message saying nothing matches their criteria.