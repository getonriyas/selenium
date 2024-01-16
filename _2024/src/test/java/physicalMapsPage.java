import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;

public class physicalMapsPage {
    public WebDriver driver;

    @FindBy(xpath = "//button[contains(.,' Project Maps ')]")
    private WebElement projectMapsButton;
    @FindBy(xpath = "//button[@aria-label='Click to open']")
    private WebElement leftAddMapButton;
    @FindBy(xpath = "//button[contains(.,'Add new Site')]")
    private WebElement addNewSiteButton;
    @FindBy(xpath = "//app-sidebar-package-maps-edit//input[@formcontrolname='name']")
    private WebElement nameField;
    @FindBy(xpath = "//app-sidebar-package-maps-edit//textarea[@data-placeholder='Description']")
    private WebElement descriptionField;
    @FindBy(xpath = "//app-sidebar-package-maps-edit//button[contains(.,'Save')]")
    private WebElement saveMapButton;
    @FindBy(xpath = "//app-msg-dialog//button[.='Discard Changes']")
    private WebElement discardChangesButtonInPopUp;
    @FindBy(xpath = "//ngx-spinner//div[contains(@class,'la-ball-fussion')]")
    private WebElement loader;
    @FindBy(xpath = "//notifier-notification[contains(@class,'notifier__notification') and .= 'Site added successfully']")
    private WebElement siteAddedMessage;
    @FindBy(xpath = "//div[@class='cdk-overlay-backdrop cdk-overlay-dark-backdrop cdk-overlay-backdrop-showing']")
    private WebElement backdropOverlay;
    @FindBy(xpath = "//app-sidebar-package-maps-edit//mat-icon[@svgicon='inv-times-circle']")
    private WebElement closeForm;
    String physicalMapsPageTitle = ".studio | Project Maps";
    @FindBy(xpath = "(//div[@class='e-headercelldiv'])[4]")
    private WebElement rightAddMapButton;

    public <T extends BaseData> boolean addSite(T obj, HashMap<String, String>[] siteTestData) {
        boolean isSiteAdded = false;
        try {
            obj.generateDataForAddSite();
            openPhysicalMaps();
            for (int i = 0; i < siteTestData.length; i++) {
                PageHelper.javascriptClick(driver, leftAddMapButton);
                PageHelper.javascriptClick(driver, addNewSiteButton);
                PageHelper.sendData(driver, nameField, siteTestData[i], "Site Name");
                PageHelper.sendData(driver, descriptionField, siteTestData[i], "Site Description");
                Assert.assertTrue(PageHelper.isButtonEnabled(driver, saveMapButton));
                PageHelper.javascriptClick(driver, saveMapButton);
                PageHelper.invisibilityOfElement(driver, loader);
                Thread.sleep(2000);
                boolean outcome = isSiteSuccessfullyAdded();
                if (outcome) {
                    isSiteAdded = true;
                } else {
                    isSiteAdded = false;
                    break;
                }

            }
        } catch (StaleElementReferenceException e) {
            leftAddMapButton.click();
        } catch (Exception ae) {
            Assert.fail(String.valueOf(ae));
            return isSiteAdded;
        } finally {
            try {
                if (backdropOverlay.isDisplayed()) {
                    PageHelper.javascriptClick(driver, closeForm);
                    if (discardChangesButtonInPopUp.isDisplayed()) {
                        PageHelper.javascriptClick(driver, discardChangesButtonInPopUp);
                    }
                }
            } catch (Exception e) {

            }

        }
        return isSiteAdded;
    }
    public boolean isSiteSuccessfullyAdded() {
        return PageHelper.validateConfirmationMessage(driver, siteAddedMessage);
    }
    public void openPhysicalMaps() {
        PageHelper.invisibilityOfElement(driver, loader);
        PageHelper.javascriptClick(driver, projectMapsButton);
        Assert.assertTrue(isPhysicalMapsPageDisplayed());
    }

    public boolean isPhysicalMapsPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.titleIs(physicalMapsPageTitle),
                    ExpectedConditions.elementToBeClickable(leftAddMapButton),
                    ExpectedConditions.elementToBeClickable(rightAddMapButton),
                    ExpectedConditions.invisibilityOf(loader)));
            return true;

        } catch (TimeoutException te) {
            //Assert.fail(String.valueOf(te));
            //te.printStackTrace();
            return false;
        }
    }
}
