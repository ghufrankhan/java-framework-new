package api.hooks;

import io.cucumber.java.Before;
import api.base.BaseTest;


public class Hooks extends BaseTest {

    // Calls the setUp method from the BaseTest class before each scenario
    @Before
    public void setUp() {
        super.setUp();
    }
}