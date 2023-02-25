package com.carcinus.code.leetcode.p_1201_1300.p_1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1237. 找出给定方程的正整数解
 * @link <a href="https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/">...</a>
 */
public class FindPositiveIntegerSolutionForAGivenEquation {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    res.add(Arrays.asList(x, y));
                }
            }
        }
        return res;
    }
}
