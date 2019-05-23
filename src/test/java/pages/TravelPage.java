package pages;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementImpl;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TravelPage {
    WebDriver driver;
    WebDriverWait wait;

    public TravelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getExplicitlyWait());
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@data-gb-name='travel-nav-data']/h5")
    private WebElement lblPlanFound;

    @FindBy(how = How.XPATH, using = "//*[@class='col-sm-4 card-full']")
    private List<WebElement> lstCard;

    private WebElement insurers(String option) {
        return driver.findElement(By.xpath(String.format("//*[@data-filter-name='%s']/input", option)));
    }

    @FindBy(how = How.XPATH, using = "//*[@class='btn-ripple more']")
    private WebElement btnSeeMore;

    @FindBy(how = How.XPATH, using = "//label[contains(.,'Trip termination')]/..//*[@class='slider-handle min-slider-handle round']")
    private WebElement minTripTermination;

    @FindBy(how = How.XPATH, using = "//label[contains(.,'Trip termination')]/..//*[@class='slider-handle max-slider-handle round']")
    private WebElement maxTripTermination;

    private WebElement sortOption(String option) {
        return driver.findElement(By.xpath(String.format("//*[@data-gb-name='sort-bar']//label[contains(.,'%s')]", option)));
    }

    @FindBy(how = How.XPATH, using = "//*[contains(@class,'select-component')]")
    private WebElement drpdwnDestination;

    private WebElement destinationOption(String option) {
        return drpdwnDestination.findElement(By.xpath(String.format("//span[.='%s']", option)));
    }

    @FindBy(how = How.NAME, using = "dates-startdate")
    private WebElement dateStart;

    @FindBy(how = How.NAME, using = "dates-enddate")
    private WebElement dateEnd;

    @FindBy(how = How.XPATH, using = "//*[@class='datepicker-days']//th[.='Today']")
    private WebElement dateToday;

    @FindBy(how = How.XPATH, using = "//*[@data-gb-name='loading-status']")
    private WebElement loading;

    public void waitForVisibility(WebElement element) throws Error {
        wait.until(visibilityOf(element));
    }

    public void waitForInvisibility(WebElement element) throws Error {
        wait.until(ExpectedConditions.not(visibilityOf(element)));
    }

    public String getPlanFound() {
        return lblPlanFound.getText();
    }

    public int getCardCount() {
        try {
            waitForVisibility(loading);
            waitForInvisibility(loading);
        } catch (Exception ex) {
            return lstCard.size();
        }
        return lstCard.size();
    }

    public void chooseInsurers(String... options) {
        for (String option : options) {
            new ElementImpl(insurers(option)).check(driver);
        }
    }

    public void setTerminationRangeMixToMax() {
        new ElementImpl(btnSeeMore).click(driver);
        Actions move = new Actions(driver);
        Action action = move.clickAndHold(minTripTermination)
                .moveToElement(maxTripTermination)
                .release(maxTripTermination)
                .build();
        action.perform();
    }

    public void selectSort(String option) {
        sortOption(option).click();
    }

    public void selectDestination(String option) {
        drpdwnDestination.click();
        new ElementImpl(destinationOption(option)).click(driver);
    }

    public void setStartDate(String date) {
        switch (date) {
            case "today":
                dateStart.click();
                dateToday.click();
                break;
            default:
                System.out.println(String.format("Unsupported or Invalid date [%s]", date));
        }
    }

    public void setEndDate(String date) {
        switch (date) {
            case "today":
                dateEnd.click();
                dateToday.click();
                break;
            default:
                System.out.println(String.format("Unsupported or Invalid date [%s]", date));
        }
    }
}
