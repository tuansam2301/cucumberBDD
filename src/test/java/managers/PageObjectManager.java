package managers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.TravelPage;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private TravelPage travelPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public TravelPage getTravelPage(){
        return (travelPage == null) ? travelPage = new TravelPage(driver) : travelPage;
    }
}
