package org.RestAssured.OCT15;

public class BuilderPattern {

    public BuilderPattern groundFloor()
    {
        System.out.println("Ground Floor");
        return this;
    }

    public  BuilderPattern firstFloor()
    {
        System.out.println("First Floor");
        return this;

    }

    public  BuilderPattern secondFloor()
    {
        System.out.println("Second Floor");
        return this;
    }
}
