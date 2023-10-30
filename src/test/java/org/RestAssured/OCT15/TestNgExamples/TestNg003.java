package org.RestAssured.OCT15.TestNgExamples;

import org.testng.annotations.Test;

public class TestNg003 {

    @Test(groups = {"smoke","QA","login"})
    public void Test1(){

        System.out.println("T1- Smoke/QA");
    }

    @Test(groups = {"smoke","PreProd"})
    public void Test2(){

        System.out.println("T2- Smoke/PreProd");
    }

    @Test(groups = {"reg","QA","login"})
    public void Test3(){

        System.out.println("T3 - Reg/QA");
    }

}
