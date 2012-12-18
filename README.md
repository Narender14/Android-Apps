Android Application :
=====================

An android application that locates Hotel, Bookstore, Mobilestore and Pizza hut nearby an institute/college 
on  Google maps.
It also locates user position using GPS which keeps updating as user changes the position.
On tapping the Overlays(small ballons on the Google maps), it shows the name and distance-in-between the store and institute. 

It has zoom-in, zoom-out, map-view and satellite-view options.

![ScreenShot](https://raw.github.com/Narender14/Android-Apps/master/College 2.png)


Development :
-------------

This application development require the knowledge of SQlite Database along with Android Development. It stores the latitude and longitute of the certain
store ( mentioned above ) into database and fetch and display them on Google Maps as Overlays.

Introduction to Sqlite Database is very well explained [HERE] (http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/)
Each Institute has a Database table which store the corresponding points or location points.

Usage (user) :
--------

    It support Andorid 2.2 and above. Download **Icollege.apk** file from */bin* directory and install it.
    
Usage (developer) :
-------------------

Download and import this project to your workspace. It has many files corresponding to Activity and Database.


Contribution :
---------------

Currently it only suppport 4 institute. It can be extended further. Any idea, bug report or patch is welcome.

    Simply fork the repo and clone it to your local machine and start contributing.























