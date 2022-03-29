package com.avis.qa.components;

import com.avis.qa.core.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.avis.qa.utilities.CommonUtils.THREE_SECONDS;
import static com.avis.qa.utilities.CommonUtils.threadSleep;


/**
 * This class contains all the elements and actions performed on Header
 *
 * @author ikumar
 */
@Log4j2
public class Header extends AbstractBasePage {

    @FindBy(xpath = "//*[contains(@id,'DropLoc_value')]")
    private WebElement dropOffLocation;

    @FindBy(xpath = "(//button[contains(text(),'Save Now')])[1] | (//button[contains(text(),'Book Now')])[1]|//button[contains(text(),'Get Rates')]")
    private WebElement BookNow_DealsPage;

    @FindBy(xpath = "((//ul[contains(@class,'header-primary')]//a[contains(text(),'Deals')])[1])|((//ul[contains(@class,'header-primary')]//a[contains(text(),'Offers')]))[1]")
    private WebElement OfferHeader;

    @FindBy(xpath = "//*[contains(text(),'US Offers')]")
    private WebElement USOffers;

    @FindBy(xpath = "(//a[contains(text(),'Cars & Services')])[1]|//a[contains(text(),'Cars')]")
    private WebElement CarsandServices;

    @FindBy(xpath = "//a[contains(text(),'Car Guide')]")
    private WebElement CarGuide;

    @FindBy(xpath = "(//*[contains(text(),'Reserve')])[2]|(//*[contains(text(),'Get rates')])[1]|(//*[contains(text(),'Book Now')])[1]")
    private WebElement CarGuideReserveButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header offersHeader() {
        waitForVisibilityOfElement(OfferHeader).click();
        USOffers.click();
        return this;
    }

    public Header clickOnOffersCTA() {
        BookNow_DealsPage.click();
        return this;
    }

    public void carAndservicesHeader() {
        CarsandServices.click();
        waitForVisibilityOfElement(CarGuide).click();
        threadSleep(THREE_SECONDS);
        waitForVisibilityOfElement(CarGuideReserveButton).click();
    }

    @Override
    public void isOnPage() {
        log.info("Verify Header Component");
        waitForVisibilityOfElement(OfferHeader);
    }
}
