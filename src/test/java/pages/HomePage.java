package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementImpl;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@aria-controls='Insurance']")
    private WebElement lnkInsurance;

    @FindBy(how = How.XPATH, using = "//a[@aria-controls='Travel']")
    private WebElement lnkTravel;

    @FindBy(how = How.NAME, using = "product-form-submit")
    private WebElement btnShowMyResults;

    public void navigateToHomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void openInsurance(){
        lnkInsurance.click();
    }

    public void openTravel(){
        openInsurance();
        lnkTravel.click();
    }

    public void submitForm(){
        new ElementImpl(btnShowMyResults).click(driver);
    }
}
