package org.RestAssured.OCT15.TestNgExamples;

import org.testng.annotations.*;

public class TestNg001 {

    @BeforeSuite
    void demo1()
    {
        System.out.println("BeforeSuite");
        // Read data from excel code
    }

    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void test1(){
        System.out.println("Test");
        // Test case
    }

    @Test
    void test2(){
        System.out.println("Test");
        // Test case
    }

    @AfterMethod
    void demo6(){
        System.out.println("AfterMethod");
    }

    @AfterSuite
    void demo9(){
        System.out.println("AfterSuite");
        // Close the SQL Database here
    }

}
