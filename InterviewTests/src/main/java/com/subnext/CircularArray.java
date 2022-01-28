package com.subnext;

public class CircularArray {

    public boolean traverse(int[] input) {

        // Keep track of visits
        int[] visitRec = new int[input.length];

        int currentIndex = 0;
        while (visitNode(visitRec, currentIndex)) { //Loop while visited all nodes exacly once.

            //Get next index to visit.
            currentIndex = nextIndexToVisit(currentIndex, input[currentIndex], input.length);

            if (checkIfEveryNodeHasBeenVisitedOnce(input)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfEveryNodeHasBeenVisitedOnce(int[] input) {
        for (int i : input) {
            if (i != 1) return false;
        }
        return true;
    }

    public int nextIndexToVisit(int currentIndex, int noOfPositions, int arrayLength) {
        int shift = (noOfPositions < 0) ? -1 : 1;

        while (noOfPositions != 0) {
            currentIndex += shift;
            noOfPositions -= shift;

            if (currentIndex >= arrayLength)
                currentIndex = 0;
            else if (currentIndex < 0)
                currentIndex = arrayLength - 1;
        }

        return currentIndex;
    }

    /**
     * Visits a node
     *
     * @param visitRec
     * @param index
     * @return Returns false if the node has been visited before.
     */
    public boolean visitNode(int[] visitRec, int index) {
        //Check if this node has been visited before.
        if (visitRec[index] > 0) {
            System.out.println("Node " + index + " was visited more than once");
            return false;
        } else {
            visitRec[index] += 1; //Increment the visit counter of a node.
            return true;
        }
    }


}
