package junittestcases;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunitTestCaseExample.class);
        for (Failure fail : result.getFailures()) {
            System.out.println(fail.toString());
        }

        /*int arr[] = new int[5];
        for(int i: arr)
        {
            System.out.println(i);

        }*/

        System.out.println(result.wasSuccessful());
    }
}