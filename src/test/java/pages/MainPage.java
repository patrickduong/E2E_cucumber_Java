package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    public void searchProduct(String productName) {
        String search_txt = "twotabsearchtextbox";
        driver.findElement(By.id(search_txt)).sendKeys(productName);
        String search_btn = "nav-search-submit-button";
        driver.findElement(By.id(search_btn)).click();
    }

}
