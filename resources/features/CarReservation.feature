@alltest
Feature: Navotar Reservation

Background:
Given user launches the URL

@postivescenario
Scenario Outline: Valid Booking
When User reserves a car with the details "<Vehicle Type>" "<PickUp Date>" "<PickUp Time>" "<Drop Off Date>" "<Drop Off time>" 
And User enters additional details with "<Location>" "<Different Drop-Off Location>" "<Drop Off Location>"
And User clicks on search and select "MPV" as vehicle
Then User clicks next to complete the booking
Examples:
| Vehicle Type | PickUp Date     | PickUp Time | Drop Off Date   | Drop Off time | Location       | Different Drop-Off Location | Drop Off Location | 
| Mini Van     | 01-January-2020 | 11:30 AM    | 03-January-2020 | 12:30 PM      | Chennai, India | Yes                         | Mumbai, India     | 

@negativescenario
Scenario Outline: Valid Booking
When User reserves a car with the details "<Vehicle Type>" "<PickUp Date>" "<PickUp Time>" "<Drop Off Date>" "<Drop Off time>" 
And User enters additional details with "<Location>" "<Different Drop-Off Location>" "<Drop Off Location>"
Then User clicks and verify the error "The Drop-off Location is closed. Please check Drop-off Location hours."
Examples:
| Vehicle Type | PickUp Date     | PickUp Time | Drop Off Date   | Drop Off time | Location       | Different Drop-Off Location | Drop Off Location  | 
| Mini Van     | 01-January-2020 | 09:00 PM    | 03-January-2020 | 09:00 PM      | Chennai, India |          No                 | Mumbai, India      | 
	
