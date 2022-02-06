# Functions with constraints
Superadmin:
* Create admin [2]
    * A muted account can not become an admin.
* Delete admin [2]
    * The first admin can not be deleted.

Admin:
* Remove user [4]
    * An user can only be deleted after a report abuse. 
* Remove comments/photo [4]
    * A comments/photo can only be deleted after a report abuse.
* Remove an ad [3]
    * An ad can only be deleted after a report abuse.
    * The advertiser gets a notification that his/her ad has been taken down. 
* Check and decide report abuse [4]
    * An admin can not view or handle a report about him-/herself.
* View gym registration [2]
    * The person who registered gets a reply which states wheither it is accepted or not.
* Mute user for a period of time [2]
    * The system decides the period of time, based on the amount of mutes in the past.

Advertiser:
* CRUD ad campaigns [4][4][4][4]
* Pay for ad campaign [1]

User:
* Register account [4]
* Login [4]
* Report abuse a post [4]
* Post a picture on social feed [5]
* Post text on social feed [4]
* Add other users as friends [3]
* Delete account [2]
* View gyms on map [5]
* See other user's profile [3]
* Change password [1]
* Predefine workout schedule [5]
* Get workout notification [5]
    * The first notification is given two hours before the planned workout.
    * Another notification is given half an hour before the planned workout.
    * If the user didn't workout for X days, the app will send a reminder.
        * Wheither the user did or did not work out, is decided by the workout calender.
* Track workout day in calender [4]

Anybody:
* Apply for gym registration (to be put on map) [2]

[5] = School requirement
[4] = Must have
[3] = Should have
[2] = Could have
[1] = Won't have

# General constraints
* The superadmin inherits all functions and constraints from the admin.
* Constraints where two admins are needed (like remove an user), the superadmin can do alone.