package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.MainPage;

import java.util.Objects;

import static cucumber.ScenarioHooks.driver;

public class AMZMainSteps {
    private final MainPage awsMainPage;

    public AMZMainSteps() {
        awsMainPage = new MainPage(driver);
    }

    @When("user select {string} at top trending search")
    public void userSelectAtTopTrendingSearch(String itemName) {
        awsMainPage.scrollUntilElementVisible(By.cssSelector(itemName));
    }

    @Then("the page should display with title is {string}")
    public void thePageShouldDisplayWithTitleIs(String pageTitle) {
        assert Objects.equals(awsMainPage.getPageTitle(), pageTitle);
    }

    @When("user sort the the item by {string} order")
    public void userSortTheTheItemByOrder(String arg0) {

    }

    @And("user add a product to shopping cart")
    public void userAddAProductToShoppingCart() {

    }

    @Then("the selected item is added to shopping card")
    public void theSelectedItemIsAddedToShoppingCard() {
    }

    @Given("user navigate to {string} url")
    public void userNavigateToUrl(String url) {
        awsMainPage.navigateTo(url);
    }
}
