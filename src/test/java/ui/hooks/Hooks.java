package ui.hooks;

import ui.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            super.takeScreenshot(scenario);
        }
        super.tearDown();
    }
}