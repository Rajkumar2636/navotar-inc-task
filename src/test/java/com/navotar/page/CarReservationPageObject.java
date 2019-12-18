package com.navotar.page;


import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class CarReservationPageObject extends PageObject {

	@FindBy(xpath="//select[contains(@data-ng-model,'vehicleType')]/option")
	public List<WebElementFacade> vehicleTypeDropdown;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'vehicleType')]")
	public WebElementFacade vehicleTypeDrop;
	
	@FindBy(xpath="//input[contains(@ng-model,'checkOut')]")
	public WebElementFacade pickUpDate;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedOutTime')]")
	public WebElementFacade checkedOutTime;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedOutTime')]/option")
	public List<WebElementFacade> checkedOutTimeOpt;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedOutLocation')]")
	public WebElementFacade checkedOutLocation;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedOutLocation')]/option")
	public List<WebElementFacade> checkedOutLocationOpt;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedInLocation')]")
	public WebElementFacade checkedInLocation;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedInLocation')]/option")
	public List<WebElementFacade> checkedInLocationOpt;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedInTime')]")
	public WebElementFacade checkedInTime;
	
	@FindBy(xpath="//select[contains(@data-ng-model,'checkedInTime')]/option")
	public List<WebElementFacade> checkedInTimeOpt;
	
	@FindBy(xpath="//input[contains(@ng-model,'checkIn')]")
	public WebElementFacade dropoffDate;
	
	@FindBy(xpath="//input[@ng-model='isDifferentDropOffLocation']")
	public WebElementFacade differentDropOffLocation;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElementFacade search;
	
	@FindBy(xpath="//li[@class='next']//button")
	public WebElementFacade next;
	
	@FindBy(xpath="//div[@ng-bind-html='alert.msg']")
	public WebElementFacade errorMessage;
	
	
	
	
	
	
	
	
}
