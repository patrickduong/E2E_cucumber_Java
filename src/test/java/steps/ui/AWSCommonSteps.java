package steps.ui;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.amazon.MainPage;
import pages.amazon.TodayDealsPage;

import java.util.Objects;

import static cucumber.ScenarioHooks.driver;

public class AWSCommonSteps {
    private final MainPage awsMainPage;
    private final TodayDealsPage awsTodayDealPage;


    public AWSCommonSteps() {
        awsMainPage = PageFactory.initElements(driver, MainPage.class);
        awsTodayDealPage = PageFactory.initElements(driver, TodayDealsPage.class);
    }

    @Then("^I select \"([^\"]*)\" at top trending search")
    public void iSelectATopTrendingSearchItem(String itemName) {
        awsMainPage.clickLink(By.linkText(itemName));
    }

    @Then("^the page should display with title is \"([^\"]*)\"")
    public void thePageShouldDisplayWithTitleIs(String pageTitle) {
        assert Objects.equals(awsMainPage.getPageTitle(), pageTitle);
    }

    @Then("^I sort the the item by \"([^\"]*)\" order")
    public void iSortTheTheItemByOrder(String orderOption) {
        awsTodayDealPage.sortByOption(orderOption);
    }

    @Then("user add a product to shopping cart")
    public void userAddAProductToShoppingCart() {

    }

    @Then("^I search a product with name is \"([^\"]*)\"")
    public void iMakeASearchWithProductName(String productName) {
        awsMainPage.searchProduct(productName);
    }

    @Then("the selected item is added to shopping card")
    public void theSelectedItemIsAddedToShoppingCard() {
    }

    @Then("^I navigate to \"([^\"]*)\"$")
    public void userNavigateToUrl(String url) {
        awsMainPage.navigateTo(url);
    }
}
