package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static contraints.TestConstraints.TODAY_DEAL_TITLE;

public class TodayDealsPage extends BasePage {

    @FindBy(id = "sorting_dropdown0")
    private WebElement sortingDropdown;

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

    public void setSortingDropdown(String option) {
        this.selectFilterSearchPage(By.id(String.valueOf(sortingDropdown)), option);
    }
}