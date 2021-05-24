package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;

    @Before
    public void createJobObjects(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertTrue("test_job1 should have an id that is different from && 1 less than test_job2",
                test_job1.getId()+1 == test_job2.getId());

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

        assertTrue("Test is to be certain that the Job constructor assigns the correct class to each field.",
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

}
