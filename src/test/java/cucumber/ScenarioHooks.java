package cucumber;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
        contextUI.getReport().captureScreenShot(scenario, contextUI.getWebDriver());
        captureFailScenario(scenario);
        contextUI.getWebDriver().quit();
    }

    private void captureFailScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) contextUI.getWebDriver()).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath.toPath(), destinationPath.toPath());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
