package com.carcinus.code.leetcode.p_2001_3000.p_2301_2400.p_2357;

/**
 * 2357. 使数组中所有元素都等于零
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {
        int[] flags = new int[101];
        int count = 0;
        for (int num : nums) {
            if (num != 0 && flags[num] == 0) {
                flags[num]++;
                count++;
            }
        }
        return count;
    }
}
