package com.avis.qa.helpers;

import com.avis.qa.components.Footer;
import com.avis.qa.components.Header;
import com.avis.qa.components.ReservationWidget;
import com.avis.qa.pages.*;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class MiscHelper {

    private final WebDriver driver;
    private final ReservationWidget reservationWidget;

    public MiscHelper(WebDriver driver) {
        this.driver = driver;
        this.reservationWidget = new ReservationWidget(driver);
    }

    public Confirmation Misc_OffersPage_Reservation(String pickUpLocation, String firstName, String lastName, String email,
                                                    String phoneNo) {

        Header header = new Header(driver);
        header.offersHeader().clickOnOffersCTA();

        reservationWidget
                .pickUpLocation(pickUpLocation)
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


    public Confirmation Misc_CarGuide_Res(String pickUpLocation, String firstName, String lastName, String email,
                                          String phoneNo) {

        Header header = new Header(driver);
        header.carAndservicesHeader();

        reservationWidget
                .pickUpLocation(pickUpLocation)
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

    public void Misc_BusinessPrograms_BaseRateGuarnatee(String wizardNo, String password, String pickup, String fName,
                                                        String lName, String email, String phone, String bestRateQuote, String lowerRateCar_bestRateQuote,
                                                        String pickupLocation, String dropOffLocation, String vehicle_Type, String webSite, String comments) {

        reservationWidget
                .pickUpLocation(pickupLocation)
                .calendarSelection()
                .selectMyCar();

        Vehicles vehicles = new Vehicles(driver);
        Extras extras = vehicles.step2Submit();
        ReviewAndBook reviewAndBook = extras.Step3Submit();

        reviewAndBook
                .clickContinueReservationButton()
                .firstname(fName)
                .lastname(lName)
                .email(email)
                .phone(phone)
                .checkTermsAndConditions()
                .step4Submit();

        Confirmation confirmation = new Confirmation(driver);
        assertTrue(confirmation.isConfirmationNumberDisplayed(), "Confirmation Number is not displayed");
        confirmation.cancelReservation();

        Footer footer = new Footer(driver);
        BaseRate baseRate = footer.clickBRG();
        baseRate.landOnBaseRateGuaranteeForm();
        baseRate.submitForm(fName, lName, email, phone, pickupLocation);
    }


}
