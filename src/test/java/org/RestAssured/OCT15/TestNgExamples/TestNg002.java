package org.RestAssured.OCT15.TestNgExamples;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNg002 {

    @Test
      void Test1(){
        System.out.println("I am Test1");

        //TestNg also will help for Verification
        //Assertion -> Expected Result == Actual Result
        // two types of Assertions are Soft and Hard

        //Soft Assertion
        String name="krishna";
//        SoftAssert sa = new SoftAssert();
//        sa.assertEquals("Krishna",name);
//        System.out.println("Execute it");
//        sa.assertAll();

        //Hard Assertion
        Assert.assertEquals("Krishna",name,"Failed Due to mismatch");
        System.out.println("End");



    }

}
