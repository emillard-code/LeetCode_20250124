package com.project.attempt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] graph1 = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(Arrays.toString(findEventualSafeStates(graph1)));

        int[][] graph2 = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(Arrays.toString(findEventualSafeStates(graph2)));

    }

    // This method returns an array of all the safe nodes in the graph[][] array.
    public static int[] findEventualSafeStates(int[][] graph) {

        // We will have all our terminal (and safe) nodes stored in this LinkedList.
        LinkedList<Integer> terminalNodes = new LinkedList();

        // We first start by adding all the terminal nodes in graph[][] to terminalNodes[].
        // Terminal nodes are defined by nodes pointing to nowhere, i.e. they're empty.
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) { terminalNodes.add(i); }
        }

        // We will use this boolean to help perform a while-loop operation.
        // We basically want to continuously apply changes to terminalNodes[]
        // until no more change can be done. The boolean will be used to test
        // at the end of each loop whether any changes have been made or not.
        boolean unchanged = false;

        // Since the challenge specifications defined a safe node as a node
        // where every possible path goes to a terminal node or another safe
        // node, we will use a while loop to add all possible safe nodes to
        // the array. We do this by using the while loop to add new safe nodes
        // during each loop until no more can be added.
        while (!unchanged) {

            // We use this to see if the Linked List had underwent any changes at the end of the loop.
            LinkedList<Integer> terminalNodesOld = new LinkedList(terminalNodes);

            // During each iteration of this loop, we check every element in graph[i]
            // to see if the current node is pointing to anything other than a safe or
            // terminal node. If it is, we set the boolean to false and don't add the
            // current node to the Linked List. Otherwise, we add it to the Linked List.
            for (int i = 0; i < graph.length; i++) {

                boolean onlySafeNodes = true;

                for (int j = 0; j < graph[i].length; j++) {
                    if (!terminalNodes.contains(graph[i][j])) { onlySafeNodes = false; }
                }

                if (onlySafeNodes && !terminalNodes.contains(i)) { terminalNodes.add(i); }

            }

            // If there's been no changes to the Linked List, we break from the while loop.
            if (terminalNodesOld.equals(terminalNodes)) { unchanged = true; }

        }

        // We revert the Linked List back to an int array here as the challenge specifications
        // asked us to return an int array. It also asked for ascending order so we perform a
        // sort operation here.
        int[] result = new int[terminalNodes.size()];
        Collections.sort(terminalNodes);

        for (int i = 0; i < terminalNodes.size(); i++) {
            result[i] = terminalNodes.get(i);
        }

        // Once we have our array, we return it.
        return result;

    }

}
