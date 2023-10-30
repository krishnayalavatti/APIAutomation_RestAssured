package org.RestAssured.OCT15;

public class MAIN {
    public static void main(String[] args) {

        // Rest Assured - Lib which help you to make the HTTP request + verify it
        //TestNg - To manage our test cases - Testing Framework
        //Allure Report - Reporting Purpose
        //Maven - Build and Dependency management and taking care of our project

        // Rest Assured - BDD Syntax - Given -> When -> Then
        // Pattern - It Follows Builder Pattern

        //NonBuilderPattern NBP = new NonBuilderPattern();
        //NBP.firstFloor();
        //NBP.secondFloor();
        //NBP.groundFloor();

        BuilderPattern BP = new BuilderPattern();
        BP.groundFloor().firstFloor().secondFloor();

    }
}
