package steps;

import cucumber.TestContext;
import cucumber.api.java.After;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context){
        testContext = context;
    }

    @After
    public void afterTestRun(){
        testContext.getWebDriverManager().closeDriver();
    }
}
