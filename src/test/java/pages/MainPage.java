package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static contraints.TestConstraints.EXPECTED_MAIN_PAGE_TITLE;

public class MainPage extends BasePage {

    @FindBy(linkText = "Today's Deals")
    private WebElement todayDeal_lnk;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement search_txt;

    @FindBy(id = "nav-search-submit-button")
    private WebElement search_btn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        search_txt.sendKeys(productName);
        search_btn.click();
    }






}
