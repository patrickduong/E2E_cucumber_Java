package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import static cucumber.ScenarioHooks.driver;

public class AMZMainSteps {

    @Given("we are on aws page")
    public void we_are_on_aws_page() {
        driver.get(driver.getCurrentUrl());
        PageFactory.initElements(driver, MainPage.class);

//        assert(Objects.equals(driver, getPage(MainPage.class)));
        System.out.println("we are on aws page");
    }

}
