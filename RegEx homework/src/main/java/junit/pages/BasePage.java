package junit.pages;

import junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForText(WebDriver driver, By by) {
        Pattern pattern = Pattern.compile("^(?!\\s*$).+");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textMatches(by, pattern));

        return driver.findElement(by);
    }
}