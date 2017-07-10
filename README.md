#Lesson 8

This lesson is mostly a presentation and code walkthrough. But there's a few bugs you can fix:
* Currently, users are only added if they change the search of the page.  
  Instead, change the frontend (App.scala) to send the location on page load, and update when they users changes destination.
* Users are not being removed when they leave/close the page. Take a look at the UserActor in UserTrackingController.scala
