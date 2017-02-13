package runner;

import listner.CustomListner;
import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.ArrayList;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class TestRunner {
    public static void main(String args[]){
        //Create TestNG instance:
        TestNG runner = new TestNG();

        //Add test-classes:
        runner.setTestClasses(new Class[]{TestClassOne.class, TestClassTwo.class});

        //Set listener:
        runner.setListenerClasses(new ArrayList<Class<? extends ITestNGListener>>(){{add(CustomListner.class);}});

        //Run them:
        runner.run();
    }
}
