package com.project;

import com.project.attempt.LeetCodeAttempt;
import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void findEventualSafeStatesTest() {

        int[][] graph1 = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};

        LinkedList<Integer> solution1 = new LinkedList<>();
        solution1.add(2);
        solution1.add(4);
        solution1.add(5);
        solution1.add(6);

        assertEquals(solution1, LeetCodeSolution.eventualSafeNodes(graph1));

        int[][] graph2 = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};

        LinkedList<Integer> solution2 = new LinkedList<>();
        solution2.add(4);

        assertEquals(solution2, LeetCodeSolution.eventualSafeNodes(graph2));

    }

}
