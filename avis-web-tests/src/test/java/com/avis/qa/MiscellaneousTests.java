//package com.avis.qa;
//
//import com.avis.qa.core.TestBase;
//import com.avis.qa.helpers.MiscHelper;
//import com.avis.qa.pages.Confirmation;
//import com.avis.qa.utilities.CSVUtils;
//import org.testng.annotations.Test;
//
//import static com.avis.qa.constants.AvisConstants.*;
//import static org.testng.Assert.assertTrue;
//
///**
// * Class contains Miscellaneous Tests
// *
// * @author ikumar
// */
//public class MiscellaneousTests extends TestBase {
//
//    @Test(groups = {REGRESSION, SANITY}, dataProvider = TEST_DATA, dataProviderClass = CSVUtils.class)
//    public void Misc_OneClick_VanityURL(String url, String title) {
//        launchUrl(getAvisUrl(url));
//        assertTrue(getDriver().getTitle().contains(title), "Page title is incorrect");
//    }
//
//    @Test(groups = {REGRESSION, SANITY}, dataProvider = TEST_DATA, dataProviderClass = CSVUtils.class)
//    public void Misc_OffersPage_Reservation(String pickUplocation, String firstName, String lastName, String email,
//                                            String phoneNo) {
//        launchUrl();
//        MiscHelper miscHelper = new MiscHelper(getDriver());
//        Confirmation confirmation = miscHelper.Misc_OffersPage_Reservation(pickUplocation, firstName, lastName, email, phoneNo);
//        assertTrue(confirmation.isConfirmationNumberDisplayed(), "Confirmation Number is not displayed");
//        confirmation.cancelReservation();
//    }
//
//
//    @Test(groups = {REGRESSION, SANITY}, dataProvider = TEST_DATA, dataProviderClass = CSVUtils.class)
//    public void Misc_BusinessPrograms_BaseRateGuarnatee(String wizardNo, String password, String pickup, String fName,
//                                                        String lName, String email, String phone, String bestRateQuote, String LowerRateCar_bestRateQuote,
//                                                        String pickupLocation, String DropOffLocation, String vehicle_Type, String webSite, String comments) {
//        launchUrl();
//        MiscHelper miscHelper = new MiscHelper(getDriver());
//        miscHelper.Misc_BusinessPrograms_BaseRateGuarnatee(wizardNo, password, pickup, fName, lName, email,
//                phone, bestRateQuote, LowerRateCar_bestRateQuote, pickupLocation, DropOffLocation, vehicle_Type,
//                webSite, comments);
//    }
//
//    @Test(groups = {REGRESSION, SANITY}, dataProvider = TEST_DATA, dataProviderClass = CSVUtils.class)
//    public void Misc_CarGuide_Res(String pickUpLoc, String firstName, String lastName, String email, String phoneNo) {
//        launchUrl();
//        MiscHelper miscHelper = new MiscHelper(getDriver());
//        Confirmation confirmation = miscHelper.Misc_CarGuide_Res(pickUpLoc, firstName, lastName, email, phoneNo);
//        assertTrue(confirmation.isConfirmationNumberDisplayed(), "Confirmation Number is not displayed");
//        confirmation.cancelReservation();
//    }
//
//
//}
