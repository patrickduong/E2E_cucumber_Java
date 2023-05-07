package pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TodayDealsPage extends BasePage {

    @FindAll({
            @FindBy(id = "native_sorting_dropdown0"),
            @FindBy(id = "s-result-sort-select")
    })
    public
    WebElement sortingDropdown;

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

    public void sortByOption(String option) {
        selectDropdownItem(sortingDropdown, option);
    }

}