package com.subnext;

import junit.framework.TestCase;

public class CircularArrayTest extends TestCase {

    private CircularArray circularArray;

    public void setUp() throws Exception {
        super.setUp();
        circularArray = new CircularArray();
    }

    public void testCircularArray(){
        int[] a = {1, 1, 1};
        assertTrue(circularArray.traverse(a));

        int[] b = {2, 1, 1};
        assertFalse(circularArray.traverse(b));

        int[] c = {1};
        assertTrue(circularArray.traverse(c));

        int[] d = {1, -1, 4};
        assertFalse(circularArray.traverse(d));
    }

    public void testCheckIfEveryNodeHasBeenVisitedOnce(){
        int [] a = {1, 1};
        assertTrue(circularArray.checkIfEveryNodeHasBeenVisitedOnce(a));

        int [] b = {0, 1};
        assertFalse(circularArray.checkIfEveryNodeHasBeenVisitedOnce(b));

        int [] d = {2};
        assertFalse(circularArray.checkIfEveryNodeHasBeenVisitedOnce(d));

        int [] e = {-1, 1, 1};
        assertFalse(circularArray.checkIfEveryNodeHasBeenVisitedOnce(e));

        int [] f = {1, 1, 2};
        assertFalse(circularArray.checkIfEveryNodeHasBeenVisitedOnce(e));
    }

    public void testNextIndexToVisit(){
        //Test basic forward movement
        assertEquals(1, circularArray.nextIndexToVisit(0,1,3));
        assertEquals(2, circularArray.nextIndexToVisit(1,1,3));
        assertEquals(0, circularArray.nextIndexToVisit(2,1,3));

        //Test moving backwards
        assertEquals(2, circularArray.nextIndexToVisit(0,-1,3));
        assertEquals(0, circularArray.nextIndexToVisit(1,-1,3));
        assertEquals(1, circularArray.nextIndexToVisit(2,-1,3));

        assertEquals(2, circularArray.nextIndexToVisit(0,2,3));
        assertEquals(0, circularArray.nextIndexToVisit(1,2,3));
        assertEquals(1, circularArray.nextIndexToVisit(2,2,3));

        assertEquals(0, circularArray.nextIndexToVisit(0,1,1));

        assertEquals(0, circularArray.nextIndexToVisit(0,12,3));
    }
}
