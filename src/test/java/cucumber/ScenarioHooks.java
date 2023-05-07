package cucumber;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class ScenarioHooks {

    private static final ScenarioContextUI contextUI = new ScenarioContextUI(System.getProperty("defaultos"), System.getProperty("defaultbrowserdriver"));
    public static WebDriver driver = contextUI.getWebDriver();

    @BeforeAll
    public static void before_all() {
    }

    @AfterAll
    public static void after_all() {
        contextUI.getWebDriver().quit();
    }

    @Before("@ui")
    public void setupForUI() {

    }

    @After("@ui")
    public void tearDownForUi(Scenario scenario) throws IOException {
        contextUI.getReport().write(scenario);
        contextUI.getReport().captureFailScenario(scenario, driver);
    }


}
