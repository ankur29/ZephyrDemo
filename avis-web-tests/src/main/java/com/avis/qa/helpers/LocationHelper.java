package com.avis.qa.helpers;

import com.avis.qa.components.ReservationWidget;
import com.avis.qa.pages.*;
import org.openqa.selenium.WebDriver;

public class LocationHelper {

    private final WebDriver driver;
    private final Homepage homepage;

    public LocationHelper(WebDriver webDriver) {
        this.driver = webDriver;
        this.homepage = new Homepage(webDriver);
    }

    public Confirmation Location_Search_MnemonicCodeRes(String pickUpLocation, String firstName, String lastName, String email,
                                                        String phoneNo) {

        Locations locations = homepage.goToFindALocationPage();

        ReservationWidget reservationWidget = locations
                .searchLocation(pickUpLocation)
                .clickOnMakeAReservation();

        reservationWidget
                .calendarSelection()
                .selectMyCar();


        Vehicles vehicles = new Vehicles(driver);
        Extras extras = vehicles.step2Submit();
        ReviewAndBook reviewAndBook = extras.Step3Submit();

        reviewAndBook
                .clickContinueReservationButton()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .phone(phoneNo)
                .checkTermsAndConditions()
                .step4Submit();

        return new Confirmation(driver);
    }

}

