package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void findEventualSafeStatesTest() {

        int[][] graph1 = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        int[] solution1 = new int[]{2,4,5,6};
        assertArrayEquals(solution1, LeetCodeAttempt.findEventualSafeStates(graph1));

        int[][] graph2 = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[] solution2 = new int[]{4};
        assertArrayEquals(solution2, LeetCodeAttempt.findEventualSafeStates(graph2));

    }

}
