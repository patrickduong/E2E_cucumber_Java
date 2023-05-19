package cucumber;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class ScenarioHooks {

    private static final ScenarioContextUI contextUI = new ScenarioContextUI(System.getProperty("defaultos"), System.getProperty("defaultbrowserdriver"));
    private static final ScenarioContextAPI contextAPI = new ScenarioContextAPI();
    public static WebDriver driver;

    @BeforeAll
    public static void before_all() {
    }

    @AfterAll
    public static void after_all() {
        contextUI.getWebDriver().quit();
    }

    @Before("@ui")
    public void setupForUI() {
        driver = contextUI.getWebDriver();
    }

    @After("@ui")
    public void tearDownForUi(Scenario scenario) throws IOException {
        contextUI.getReport().write(scenario);
        contextUI.getReport().captureFailScenario(scenario, driver);
    }

    @Before("@api")
    public void setupForAPI(){
        ScenarioContextAPI.setupURL("https://jsonplaceholder.typicode.com");
        contextAPI.getReport().getRestLogPrintStream();
    }

    @After("@api")
    public void tearDownForApi(Scenario scenario) throws IOException {
        contextAPI.getReport().write(scenario);
    }

}
