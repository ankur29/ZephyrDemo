//package com.avis.qa;
//
//
//import com.avis.qa.core.TestBase;
//import com.avis.qa.pages.Homepage;
//import io.qameta.allure.Story;
//import org.testng.annotations.Test;
//
//import static com.avis.qa.constants.AvisConstants.*;
//import static org.testng.Assert.assertTrue;
//
///**
// * Class to test the framework
// *
// * @author ikumar
// */
//public class FrameworkTests extends TestBase {
//
//    /**
//     * ALM Testcase: NA
//     */
//    @Test(groups = {SANITY, REGRESSION})
//    @Story(HOMEPAGE)
//    public void verifyHomepageLogo() {
//        launchUrl();
//        Homepage homePage = new Homepage(getDriver());
//        assertTrue(homePage.isAvisLogoDisplayed(),"Avis logo is not displayed");
//    }
//
//}
