package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //use io.cucumber.java to import this hook

    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    //we use special class 'scenario class' from cucumber cuz it holds the complete information of your execution
    @After
    public void postCondition(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            //failed screenshot will be available inside failed folder
            pic = takeScreenshot("failed/" + scenario.getName());
        }else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        //to attach the screenshot in our report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }

}
