package com.avis.qa.pages;

import com.avis.qa.core.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.avis.qa.core.Configuration.URL;


/**
 * This class contains all the elements and actions performed on BaseRate Page
 *
 * @author ikumar
 */
@Log4j2
public class BaseRate extends AbstractBasePage {

    @FindBy(id = "firstName")
    private WebElement BRGFirstName;

    @FindBy(xpath = "//a[contains(text(),'Best Price Pledge')]")
    private WebElement BRG;

    @FindBy(xpath = "//span[@class='btn-rte-avis']")
    private WebElement BRGFormButton;

    @FindBy(id = "lastName")
    private WebElement BRGLastName;

    @FindBy(id = "email")
    private WebElement BRGEmail;

    @FindBy(id = "phone")
    private WebElement BRGPhone;

    @FindBy(id = "reservationNumber")
    private WebElement BRGConfNo;

    @FindBy(id = "amountQuoted")
    private WebElement BRGQuoted;

    @FindBy(id = "pickupLocationId_value")
    private WebElement BRGPUL;

    @FindBy(id = "dropLocationId_value")
    private WebElement BRGDOL;

    @FindBy(id = "typeOfVehicle")
    private WebElement BRGVehicle;

    @FindBy(id = "website")
    private WebElement BRGWebsite;

    @FindBy(id = "Submit Claim")
    private WebElement BRGSubmit;

    @FindBy(id = "((//div[@class='angucomplete-results'])[1]//div[@class='angucomplete-description'])[1] | ((//div[@id='PicLoc_dropdown'])[1]//div[@class='angucomplete-row'])[1]")
    private WebElement sugestionLocation;

    public BaseRate(WebDriver driver) {
        super(driver);
    }

    public BaseRate landOnBaseRateGuaranteeForm() {
        helper.scrollToElement(BRGFormButton);
        clickUsingJS(waitForVisibilityOfElement(BRGFormButton));
        return this;
    }

    public BaseRate submitForm(String firstName, String lName, String email, String phone, String pickupLocation) {
        BRGFirstName.sendKeys(firstName);
        BRGLastName.sendKeys(lName);
        BRGEmail.sendKeys(email);
        BRGPhone.sendKeys(phone);
        BRGConfNo.sendKeys(firstName);
        BRGQuoted.sendKeys("1234");
        BRGPUL.sendKeys(pickupLocation);
        //clickUsingJS(waitForVisibilityOfElement(sugestionLocation));
        BRGDOL.sendKeys(pickupLocation);
        //clickUsingJS(waitForVisibilityOfElement(sugestionLocation));
        helper.selectValueFromDropDown(BRGVehicle, 1);
        BRGWebsite.sendKeys(URL);
        //waitForVisibilityOfElement(BRGSubmit).click();

        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Base Rate Claims Page");
        waitForVisibilityOfElement(BRGFormButton);
    }
}
