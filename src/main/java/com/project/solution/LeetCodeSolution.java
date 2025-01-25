package com.project.solution;

import java.util.*;

public class LeetCodeSolution {

    public static void main(String[] args) {

        int[][] graph1 = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph1));

        int[][] graph2 = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(eventualSafeNodes(graph2));

    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] indegree = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }

        }

        Queue<Integer> q = new LinkedList<>();

        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { q.add(i); }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {

            int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {

                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) { q.add(neighbor); }

            }

        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) { safeNodes.add(i); }
        }

        return safeNodes;

    }

}
