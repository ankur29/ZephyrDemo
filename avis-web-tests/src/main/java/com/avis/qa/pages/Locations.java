package com.avis.qa.pages;


import com.avis.qa.components.ReservationWidget;
import com.avis.qa.core.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains all the elements and actions performed on Locations Page
 *
 * @author ikumar
 */
@Log4j2
public class Locations extends AbstractBasePage {

	@FindBy(id = "PicLoc_value")
	WebElement SearchField;

	@FindBy(xpath = "(//*[contains(@class,'btn browse-CTA-btn ')])[1]")
	WebElement BrowseByCountry;

	@FindBy(xpath = "//*[contains(text(),'Canada & USA')]")
	WebElement CanadaUsaCategory;

	@FindBy(xpath = "(//button[contains(text(),'USA')])[2] | //button[contains(text(),'United States')]")
	WebElement USACategory;

	@FindBy(xpath = "//button[contains(text(),'United States')]")
	WebElement UnitedStatesCategory;

	@FindBy(xpath = "//button[contains(text(),'Newark')]")
	WebElement NewarkCategory;

	@FindBy(xpath = "//button[contains(text(),'New Jersey')]")
	WebElement NewJersyCategory;

	@FindBy(xpath = "(//*[contains(text(),'Newark')])[4]")
	WebElement NewarkAirportCategory;

	@FindBy(xpath = "//button[contains(text(),'Abg/parsippany')]")
	WebElement ABGparsiPpanyCategory;

	@FindBy(xpath = "(//a[contains(text(), 'Make a Reservation')])[3]")
	WebElement makeAReservationButton;


	public Locations(WebDriver driver) {
		super(driver);
	}

	public Locations searchLocation(String pickUpLocation) {
		ReservationWidget reservationWidget = new ReservationWidget(driver);
		reservationWidget.pickUpLocation(pickUpLocation);
		//SearchField.sendKeys(pickUpLocation);
		//predefinedEvents.clickonElement("SearchFieldSuggestion");
		return this;
	}

	public ReservationWidget clickOnMakeAReservation() {
		makeAReservationButton.click();
		return new ReservationWidget(driver);
	}

//
//	public void locationLinkSelection() {
//		predefinedEvents.clickonElement("LocationLink_Paylesscar");
//	}

	public void browserLocation() {

		waitForVisibilityOfElement(BrowseByCountry).click();
		waitForVisibilityOfElement(CanadaUsaCategory).click();
		waitForVisibilityOfElement(USACategory).click();
		waitForVisibilityOfElement(NewJersyCategory).click();
		waitForVisibilityOfElement(ABGparsiPpanyCategory).click();

	}

	public boolean isMakeAReservationButtonDisplayed(){
		return makeAReservationButton.isDisplayed();
	}

	@Override
	public void isOnPage() {
		log.info("Verify Locations Page");
		waitForVisibilityOfElement(SearchField);
	}
}
