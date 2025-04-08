package ui.hooks;

import ui.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    // Calls the setUp method from the BaseTest class before each scenario
    @Before
    public void setUp() {
        super.setUp();
    }

    // Calls the takeScreenshot method from the BaseTest class after each scenario if it fails
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            super.takeScreenshot(scenario);
        }
        // Quits the driver after each scenario
        super.tearDown();
    }
}