|      Name:     |Login the app |
|:--------------:|:-|
|     Actor:     |Admin, registered user   |
|  Description:  |Actor logs in the app  |
| Pre-condition: |Actor should have an account already.   |
|    Scenario:   |1.System displays the login form. <br> 2.Actor fills in the login credentials. <br> 3.System checks credentials. <br> 4.System logs the actor in.    |
|     Result:    |User can login the app successfully   |
|   Extensions:  |No   |
|   Exceptions:  |3.1. System message: “Invalid credentials”. <br> 3.2. Use case ends here   |

|      Name:     |Register account |
|:--------------:|:-|
|     Actor:     |Unregistered user  |
|  Description:  |Actor registers a new account  |
| Pre-condition: |Actor should have an account already.   |
|    Scenario:   |1. Actor chooses to register for a new account. <br> 2. System ask the actor to enter required fields. <br> 3. Actor enters the fields. <br> 4. System checks the entered information. <br> 5. System creates new account. <br> 6. System informs that new account has been created    |
|     Result:    |Actor registers new account successfully.   |
|   Extensions:  |None   |
|   Exceptions:  |4.1 Information is not acceptable <br> 4.2 return to 2  |

|      Name:     |Post picture/text |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor uploads a post  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1.Actor logs in the app <br> 2.Actor chooses to upload a new post <br> 3.System asks actor to choose and to enter what to post <br> 4.Actor creates a new post <br> 5.Actor chooses to submit the post <br> 6.System receives the information and processes the procedure <br> 7.System informs that the new post has been uploaded successfully.   |
|     Result:    |Actor can upload a post successfully   |
|   Extensions:  |5a Actor choose to cancel creating the post <br> 1.Return to 1   |
|   Exceptions:  |7. System informs the post can be uploaded because the post is empty <br> 7.1 Use case ends here  |

|      Name:     |View other’s profile |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor is able to view other’s profile  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1.Actor logs in the app <br> 2.Actor chooses an account <br> 3.System directs actor to the account’s page. <br> 4.Actor chooses to view the account’s profile. <br> 5.System shows the account’s profile.   |
|     Result:    |Actor views other’s account profile successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Report a post |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor reports a post  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1.Actor logs in the app. <br> 2.Actor choose to report a post. <br> 3.System asks actor for a reason. <br> 4.Actor chooses a reason <br> 5.System inform that the report has been sent to an admin   |
|     Result:    |Actor reports a post successfully   |
|   Extensions:  |4a. Actor chooses to cancel the report <br> 1.Return to 1   |
|   Exceptions:  |None  |

|      Name:     |Delete account |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor deletes their account  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1.Actor logs in the app. <br> 2.Actor chooses their profile page. <br> 3.System leads the actor to their profile page. <br> 4.Actor chooses to delete their account <br> 5.System asks the actor to confirm their request to delete account. <br> 6.Actor confirms that they want to delete their account. <br> 7.System processes the account deletion. <br> 8.System logs the actor out.   |
|     Result:    |Actor deletes their account successfully   |
|   Extensions:  |6a. Actor cancels the account deletion process. <br> 1. Return to 3   |
|   Exceptions:  |None  |

|      Name:     |Change password |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor changes password  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1.Actor logs in the app. <br> 2.Actor chooses their profile page. <br> 3.System leads the actor to their profile page. <br> 4.Actor chooses to change a new password <br> 5.System asks the actor to enter their current password <br> 6.Actor enters their current password <br> 7.System checks if the entered current password is correct <br> 8.System asks the actor to enter a new password <br> 9.System checks if the password is correct <br> 10.Actor enters new password <br> 11.System checks if the password is acceptable <br> 12.System asks the actor to enter the new password for one more time <br> 13.Actor enters the new password again <br> 14.System checks if the passwords are matched <br> 15.System inform that the password has been changed   |
|     Result:    |Actor can change password successfully   |
|   Extensions:  |None   |
|   Exceptions:  |7a. System informs that the current password is not correct. <br> 1. Return to 5 <br> 9a. System informs that the new password is not acceptable <br> 1. Return to 8 <br> 14a.System informs that the two passwords are not match <br> 1. Return to 12 |

|      Name:     |Search account |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor search for an account  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor enter an account for searching <br> 3. System receives the information <br> 4. System displays the result   |
|     Result:    |Actor can search for an account successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Add friend |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor adds new friend  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor searches account <br> 2. Actor choose an account <br> 3. System display the account’s page <br> 4. Actor choose to add friend <br> 5. System sends the friend request to the account   |
|     Result:    |Actor can add new friend    |
|   Extensions:  |None   |
|   Exceptions:  |None  |


|      Name:     |Predefine workout schedule |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor set their workout schedule  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to set workout schedule <br> 3. System asks actor to enter their workout schedule <br> 4. Actor enters their workout time <br> 5. System receives the information <br> 6. System saves the actor’s workout schedule  |
|     Result:    |Actor predefines workout schedule successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |View gym on map |
|:--------------:|:-|
|     Actor:     |Registered user  |
|  Description:  |Actor views gym on map  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor selects gym’s account <br> 3. System shows gym’s page <br> 4. Actor chooses to view gym on map <br> 5. System displays the location of gym on map  |
|     Result:    |Actor can view gym on map   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Create admin |
|:--------------:|:-|
|     Actor:     |Super admin  |
|  Description:  |Actor creates an admin account  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to create new admin account <br> 3. System asks actor to enter required fields <br> 4. Actor enters the information <br> 5. System checks the information <br> 6. System informs that the new admin account has been created  |
|     Result:    |Actor can create a new admin account   |
|   Extensions:  |None   |
|   Exceptions:  |4.1 The information is not acceptable <br> 4.2 return step 3  |

|      Name:     |Delete admin |
|:--------------:|:-|
|     Actor:     |Super admin  |
|  Description:  |Actor delete an admin account  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor choose to delete admin <br> 3. System asks actor to enter the account for deletion <br> 4. Actor enters the account <br> 5. System checks the entered account <br> 6. System asks actor to confirm  <br> 7. Actor confirms <br> 8. System informs that the account has been deleted  |
|     Result:    |Actor can delete a new admin account   |
|   Extensions:  |None   |
|   Exceptions:  |5.1 The account is not available <br> 5.2 return to 3  |

|      Name:     |Remove user |
|:--------------:|:-|
|     Actor:     |Super admin, admin  |
|  Description:  |Actor delete a user account  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor choose to delete a user <br> 3. System asks actor to enter the account for deletion <br> 4. Actor enters the account <br> 5. System checks the entered account <br> 6. System asks actor to confirm  <br> 7. Actor confirms <br> 8. System informs that the account has been deleted  |
|     Result:    |Actor deletes the account successfully   |
|   Extensions:  |None   |
|   Exceptions:  |5.1 The account is not available <br> 5.2 return to 3  |

|      Name:     |Remove comment/photo |
|:--------------:|:-|
|     Actor:     |Super admin, admin  |
|  Description:  |Actor delete a comment/photo  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor choose to delete comment/photo <br> 3. System asks actor to confirm  <br> 4. Actor confirms <br> 5. System informs that the comment/photo has been deleted  |
|     Result:    |Actor deletes the comment/photo successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Remove an ad |
|:--------------:|:-|
|     Actor:     |Super admin, admin  |
|  Description:  |Actor delete an ad  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor choose to delete an ad <br> 3. System asks actor to confirm  <br> 4. Actor confirms <br> 5. System informs that the ad has been deleted  |
|     Result:    |Actor removes an ad successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Mute user |
|:--------------:|:-|
|     Actor:     |Super admin, admin  |
|  Description:  |Actor mutes user  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to mute user <br> 3. System informs that the user has been muted   |
|     Result:    |Actor mutes user successfully   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |View report |
|:--------------:|:-|
|     Actor:     |Super admin, admin  |
|  Description:  |Actor views report  |
| Pre-condition: |Actor has an admin account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to view the report <br> 3. System displays reports   |
|     Result:    |Actor views the reports   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Create ad campaign |
|:--------------:|:-|
|     Actor:     |Advertiser  |
|  Description:  |Actor creates ad campaign  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to create ad campaigns <br> 3. System asks actor to enter the campaign details <br> 4. Actor enter the campaign <br> 5. System processes the information <br> 6. System informs that the campaign has been created  |
|     Result:    |Actor can create ad campaigns   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Read ad campaign |
|:--------------:|:-|
|     Actor:     |Advertiser  |
|  Description:  |Actor creates ad campaign  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor logs in <br> 2. Actor chooses to view ad campaigns <br> 3. System displays list of ad campaigns of the actor <br> 4. Actor select an ad campaign post <br> 5. System display an ad campaign  |
|     Result:    |Actor can read ad campaigns   |
|   Extensions:  |None   |
|   Exceptions:  |None  |

|      Name:     |Update ad campaign |
|:--------------:|:-|
|     Actor:     |Advertiser  |
|  Description:  |Actor updates ad campaign  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor read ad campaign <br> 2. Actor chooses to update ad campaign <br> 3. System asks actor to edit the campaign post <br> 4. Actor edits the post <br> 5. System processes the new edition <br> 6. System informs that the ad campaign has been edited  |
|     Result:    |Actor can update campaigns   |
|   Extensions:  |4a. Actor cancel edition <br> 1. use case ends here   |
|   Exceptions:  |None  |

|      Name:     |Delete ad campaign |
|:--------------:|:-|
|     Actor:     |Advertiser  |
|  Description:  |Actor deletes ad campaign  |
| Pre-condition: |Actor has an account.   |
|    Scenario:   |1. Actor read ad campaign <br> 2. Actor chooses to delete the ad campaign <br> 3. System asks for confirmation <br> 4. Actor confirms for deletion <br> 5. System deletes the ad campaign <br> 6. System informs that the ad campaign has been deleted  |
|     Result:    |Actor can delete campaigns   |
|   Extensions:  |4a. Actor cancel deletion <br> 1. use case ends here.   |
|   Exceptions:  |None  |
