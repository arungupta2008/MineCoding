package com.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    public void testApp1()
    {
        assertFalse( false );
    }

    public void testApp2()
    {
        App app = new App();
        assertTrue(app.response(false) == false);
    }

    public void testApp3()
    {
        App app = new App();
        assertTrue(app.response(true) == true);
    }
}
