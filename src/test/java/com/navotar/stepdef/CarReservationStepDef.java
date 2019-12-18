package com.navotar.stepdef;

import com.navotar.steplib.CarReservationSteplib;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarReservationStepDef {
	CarReservationSteplib carReservation;
	
	@Given("^user launches the URL$")
	public void user_launches_the_URL() {
		carReservation.launchURL();
	}

	@When("^User reserves a car with the details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_reserves_a_car_with_the_details(String vehicletype, String pickupdate, String pickuptime,
			String dropoffdate, String dropofftime) throws InterruptedException {
		carReservation.reserveWithDetails(vehicletype,pickupdate,pickuptime,dropoffdate,dropofftime);
	}

	@And("^User enters additional details with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enters_additional_details_with(String location, String differentdropofflocation,
			String dropofflocation) {
		carReservation.reserveWithAdditionalDetails(location,differentdropofflocation,dropofflocation);
	}

	@And("^User clicks on search and select \"([^\"]*)\" as vehicle$")
	public void user_clicks_on_search_and_select_as_vehicle(String vehicle) {
		carReservation.searchAndchooseVehicle(vehicle);
	}

	@Then("^User clicks next to complete the booking$")
	public void user_clicks_next_to_complete_the_booking() {
		carReservation.nextCompleteBooking();
	}
	
	@When("^User clicks and verify the error \"([^\"]*)\"$")
	public void user_clicks_and_verify_the_error(String errorText) {
		carReservation.verifyInvalidBooking(errorText);
	}

}
