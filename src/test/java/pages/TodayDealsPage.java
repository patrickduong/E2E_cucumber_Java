package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodayDealsPage extends BasePage {

    @FindBy(css = "#sorting_dropdown0")
    public
    WebElement sortingDropdown;

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

}