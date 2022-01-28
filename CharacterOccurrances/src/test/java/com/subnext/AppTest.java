package com.subnext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testFindOccurances(){
        App app = new App();
        //Test for a normal String
        Map<Character, Integer> data = app.findOccurances("This is a sample String");
        assertNotNull(data);
        assertEquals(new Integer(2), data.get(new Character('a')));

        //Test for a null
        assertNotNull(app.findOccurances(null));

        //Test for a string without chars
        assertNotNull(app.findOccurances(""));

    }
}
