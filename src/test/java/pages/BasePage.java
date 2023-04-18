package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static com.google.common.base.Preconditions.checkNotNull;
import static contraints.TestConstraints.DEFAULT_WAIT_SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasePage {

    final WebDriver _driver;
    public static BasePage currentPage;

    public BasePage(WebDriver driver) {
        currentPage = this;
        _driver = driver;
    }

    public String getPageTitle() {
        return currentPage._driver.getTitle();
    }

    public void navigateTo(String url) {
        currentPage._driver.navigate().to(url);
    }

    public static <T extends BasePage> T getPage(Class<T> pageClass) {
        return pageClass.cast(checkNotNull(currentPage));
    }

    WebDriverWait getWait() {
        return new WebDriverWait(_driver, DEFAULT_WAIT_SECONDS);
    }

    public void scrollPage(String position) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        switch (position) {
            case "top":
                js.executeScript("window.scrollTo(0,0)");
                break;
            case "middle":
                js.executeScript("window.scrollTo(0,600)");
                break;
            case "bottom":
                js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                break;
        }
    }

    public void scrollUntilElementVisible(By element) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        js.executeScript("arguments[0].scrollIntoView()", _driver.findElement(element));
    }

    public void selectFilterSearchPage(By element, String filter) {
        Select dropdown = new Select(_driver.findElement(element));
        dropdown.selectByVisibleText(filter);
    }

}