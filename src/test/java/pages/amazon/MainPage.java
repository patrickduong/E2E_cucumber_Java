package pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "twotabsearchtextbox")
    public
    WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    public
    WebElement searchButton;

    public void searchProduct(String productName) {
        searchField.sendKeys(productName);
        searchButton.click();
    }



}
