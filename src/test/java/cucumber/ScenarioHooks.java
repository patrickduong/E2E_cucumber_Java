package cucumber;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class ScenarioHooks {

    private static final ScenarioContextUI contextUI = new ScenarioContextUI();
    public static WebDriver driver = contextUI.getWebDriver();

    @BeforeAll
    public static void before_all() {


    }

    @AfterAll
    public static void after_all() {

    }

    @Before("@ui")
    public void setupForUI() {


    }

    @After("@ui")
    public void tearDownForUi(Scenario scenario) throws IOException {

        contextUI.getReport().write(scenario);
        contextUI.getReport().captureScreenShot(scenario, driver);
        contextUI.getReport().captureFailScenario(scenario, driver);
        contextUI.getWebDriver().quit();
    }


}
