package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    String test_Job_String;
    Stream<String> stringStream;
    List<String> lineList;


    @Before
    public void createJobObjects(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //define the variables needed to test toString() method. -Chris
        test_Job_String = test_job3.toString();
        stringStream = test_Job_String.lines();
        lineList = stringStream.collect(Collectors.toList());
    }

    @Test
    public void testSettingJobId(){
        assertEquals("test_job1 should have an id that is different from && 1 less than test_job2",
                test_job1.getId() + 1, test_job2.getId());

    }
    @Test
    public void testJobConstructorSetsAllFields(){

        String[] expectedValues = {
                "Product tester",
                "ACME",
                "Desert",
                "Quality control",
                "Persistence"};
        String[] actualValuesAssigned = {
                test_job3.getName(),
                test_job3.getEmployer().getValue(),
                test_job3.getLocation().getValue(),
                test_job3.getPositionType().getValue(),
                test_job3.getCoreCompetency().getValue()};

        assertArrayEquals(expectedValues,actualValuesAssigned);

        assertTrue("Ensure that the Job constructor assigns the correct class to each field.",
                 (
                         test_job3.getId() - test_job3.getId() == 0) &&
                         (test_job3.getName() instanceof String) &&
                         (test_job3.getEmployer() instanceof Employer) &&
                         (test_job3.getLocation() instanceof Location) &&
                         (test_job3.getPositionType() instanceof PositionType) &&
                         (test_job3.getCoreCompetency() instanceof CoreCompetency));
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringBeginsAndEndsWithBlankLine(){

        assertEquals("", lineList.get(0));
        assertEquals("", lineList.get(lineList.size() - 1));
    }

    @Test
    public void testToStringHasCorrectDataPerLine(){
        assertEquals("ID: "+test_job3.getId(),lineList.get(1));
        assertEquals("Name: "+test_job3.getName(),lineList.get(2));
        assertEquals("Employer: "+test_job3.getEmployer().getValue(),lineList.get(3));
        assertEquals("Location: "+test_job3.getLocation().getValue(),lineList.get(4));
        assertEquals("Position Type: " +test_job3.getPositionType().getValue(),lineList.get(5));
        assertEquals("Core Competency: "+test_job3.getCoreCompetency().getValue(),lineList.get(6));
    }

    @Test
    public void testToStringNullField(){
        Job test_job5 = new Job("Product tester", new Employer(), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals("Ensures both empty strings and null values are printed as 'Data not available'.",
                "\nID: "+ test_job5.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n\n",test_job5.toString());

    }

    @Test
    public void testIfAllValuesMissing(){
        assertEquals("\nOOPS! This job does not seem to exist.\n", test_job1.toString());
    }

}
