package com.avis.qa;


import com.avis.qa.core.TestBase;
import com.avis.qa.helpers.LocationHelper;
import com.avis.qa.pages.Confirmation;
import com.avis.qa.pages.Homepage;
import com.avis.qa.pages.Locations;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.avis.qa.constants.AvisConstants.*;
import static org.testng.Assert.assertTrue;

/**
 * Class to test the location functionality
 *
 * @author ikumar
 */
public class LocationTests extends TestBase {


    /**
     * To verify the Browse functionality on the Location Page
     */
    @Test(groups = {REGRESSION, SANITY, SMOKE})
    public void Location_Browse_Category() {
        launchUrl();
        Homepage homepage = new Homepage(getDriver());
        Locations locations = homepage.goToFindALocationPage();
        locations.browserLocation();
        Assert.assertTrue(locations.isMakeAReservationButtonDisplayed(), "Make a Reservation button is not displayed");
    }

    /**
     * To search for the location from location field.
     **/
    //@Test(groups = {REGRESSION, SANITY}, dataProvider = TEST_DATA, dataProviderClass = CSVUtils.class)
    public void Location_Search_MnemonicCodeRes(String pickUpLocation, String firstName, String lastName, String email,
                                                String phoneNo) {
        launchUrl();
        LocationHelper locationHelper = new LocationHelper(getDriver());
        Confirmation confirmation = locationHelper.Location_Search_MnemonicCodeRes(pickUpLocation, firstName, lastName, email, phoneNo);
        assertTrue(confirmation.isConfirmationNumberDisplayed(), "Confirmation Number is not displayed");
        confirmation.cancelReservation();
    }

}
