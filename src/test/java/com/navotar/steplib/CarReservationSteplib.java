package com.navotar.steplib;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.navotar.page.CarReservationPageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CarReservationSteplib extends PageObject {

	/**
	 * Scroll to specific element
	 * 
	 */
	public void ScrolltoElementJS(WebElementFacade element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	CarReservationPageObject carReservationPageObject;

	public void launchURL() {

		getDriver().get(
				"http://67.43.12.211/NavotarReservation/?clientid=321&mode=qa&AspxAutoDetectCookieSupport=0#/?lang=en");
	}

	public void reserveWithDetails(String vehicletype, String pickupdate, String pickuptime, String dropoffdate,
			String dropofftime) throws InterruptedException {

		// Vehicle
		waitForAngularRequestsToFinish();
		carReservationPageObject.vehicleTypeDrop.click();
		listElementClick(carReservationPageObject.vehicleTypeDropdown, vehicletype);

		// pickupdate
		carReservationPageObject.pickUpDate.clear();
		carReservationPageObject.pickUpDate.sendKeys(pickupdate);

		// pickuptime
		carReservationPageObject.checkedOutTime.click();
		listElementClick(carReservationPageObject.checkedOutTimeOpt, pickuptime);

		// dropoffdate
		carReservationPageObject.dropoffDate.clear();
		carReservationPageObject.dropoffDate.sendKeys(dropoffdate);

		// droppofftime
		carReservationPageObject.checkedInTime.click();
		listElementClick(carReservationPageObject.checkedInTimeOpt, dropofftime);
	}

	public void reserveWithAdditionalDetails(String location, String differentdropofflocation, String dropofflocation) {
		// differentdropofflocation
		if (differentdropofflocation.equalsIgnoreCase("Yes"))
			carReservationPageObject.differentDropOffLocation.click();

		// location
		carReservationPageObject.checkedOutLocation.click();
		listElementClick(carReservationPageObject.checkedOutLocationOpt, location);

		// location
		if (differentdropofflocation.equalsIgnoreCase("Yes")) {
			carReservationPageObject.checkedInLocation.click();
			listElementClick(carReservationPageObject.checkedInLocationOpt, dropofflocation);
		}
	}

	public void searchAndchooseVehicle(String vehicleinNextpage) {
		carReservationPageObject.search.click();
		waitForAngularRequestsToFinish();
		List<WebElement> nameofVehicle = getDriver()
				.findElements(By.xpath("//div[contains(@class,'one-page-vname')]//h4"));
		System.out.println(nameofVehicle.size());
		for (int i = 0; i < nameofVehicle.size(); i++) {
			System.out.println(nameofVehicle.get(i).getText() + "---" + vehicleinNextpage);
			if (nameofVehicle.get(i).getText().equalsIgnoreCase(vehicleinNextpage)) {
				waitForAngularRequestsToFinish();
				int j = i + 1;
				WebElement element = getDriver().findElement(By.xpath("(//input[@type='radio'])[" + j + "]"));
				JavascriptExecutor executor = (JavascriptExecutor) getDriver();
				executor.executeScript("arguments[0].click();", element);
			}
		}
	}

	public void nextCompleteBooking() {
		carReservationPageObject.next.click();
		waitForAngularRequestsToFinish();
	}
	
	public void verifyInvalidBooking(String errorText) {
		carReservationPageObject.search.click();
		Assert.assertTrue("Error Message Mismatched", errorText.trim().equalsIgnoreCase(carReservationPageObject.errorMessage.getText().trim()));
		
	}
	public void listElementClick(List<WebElementFacade> element, String text) {
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().trim().equalsIgnoreCase(text.trim())) {
				ScrolltoElementJS(element.get(i));
				element.get(i).click();
			}
		}

	}

	
}
