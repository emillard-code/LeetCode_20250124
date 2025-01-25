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

    public static int[] findEventualSafeStates(int[][] graph) {

        LinkedList<Integer> terminalNodes = new LinkedList();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) { terminalNodes.add(i); }
        }

        boolean unchanged = false;

        while (!unchanged) {

            LinkedList<Integer> terminalNodesOld = new LinkedList(terminalNodes);

            for (int i = 0; i < graph.length; i++) {

                boolean onlySafeNodes = true;

                for (int j = 0; j < graph[i].length; j++) {
                    if (!terminalNodes.contains(graph[i][j])) { onlySafeNodes = false; }
                }

                if (onlySafeNodes && !terminalNodes.contains(i)) { terminalNodes.add(i); }

            }

            if (terminalNodesOld.equals(terminalNodes)) { unchanged = true; }

        }

        int[] result = new int[terminalNodes.size()];
        Collections.sort(terminalNodes);

        for (int i = 0; i < terminalNodes.size(); i++) {
            result[i] = terminalNodes.get(i);
        }

        return result;

    }

}
