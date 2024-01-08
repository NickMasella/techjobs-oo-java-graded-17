package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class

JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job a = new Job();
        Job b = new Job();
        assertNotEquals(a.getId(), b.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob instanceof Job);
        assertEquals(testJob.getName(), "Product tester" );
        assertEquals(testJob.getEmployer().getValue(), "ACME" );
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job a = new Job("Test Name", new Employer("testE"), new Location("testL"), new PositionType("testP"), new CoreCompetency("testC"));
        Job b = new Job("Test Name", new Employer("testE"), new Location("testL"), new PositionType("testP"), new CoreCompetency("testC"));
        assertFalse(a.equals(b));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("test", new Employer("testE"), new Location("testL"), new PositionType("testP"), new CoreCompetency("testC"));
        String firstChar = String.valueOf(testJob.toString().charAt(0));
        String lastChar = String.valueOf(testJob.toString().charAt(testJob.toString().length()-1));
        assertEquals(firstChar, "\n");
        assertEquals(lastChar, "\n");
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("test", new Employer("testE"), new Location("testL"), new PositionType("testP"), new CoreCompetency("testC"));
        String jobString = "\nID: " + job.getId() + "\n" +
                "Name: test\n" +
                "Employer: testE\n" +
                "Location: testL\n" +
                "Position Type: testP\n" +
                "Core Competency: testC\n";
        assertEquals(jobString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("test", new Employer(""), new Location("testL"), new PositionType("testP"), new CoreCompetency("testC"));
        String jobString = "\nID: " + job.getId() + "\n" +
                "Name: test\n" +
                "Employer: Data not available\n" +
                "Location: testL\n" +
                "Position Type: testP\n" +
                "Core Competency: testC\n";
        assertEquals(jobString, job.toString());
    }
}
