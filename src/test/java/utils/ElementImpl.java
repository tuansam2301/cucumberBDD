package utils;

import managers.FileReaderManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementImpl implements Element {
    private final WebElement element;
    private WebDriverWait wait;

    public ElementImpl(final WebElement element) {
        this.element = element;
    }

    public void click(WebDriver driver) {
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getExplicitlyWait());
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void click() {

    }

    public void check(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void submit() {

    }

    public void sendKeys(CharSequence... charSequences) {
    }

    public void sendKeys(WebDriver driver, CharSequence... charSequences){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, charSequences);
    }

    public void clear() {

    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public String getText() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public Coordinates getCoordinates() {
        return null;
    }

    public WebElement getWrappedElement() {
        return null;
    }
}
