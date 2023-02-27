package com.carcinus.code.leetcode.p_1_100.p_1;

/**
 * 1. 两数之和
 * @link <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
 *
 * 直接暴力遍历
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {-3, 4, 3, 9};
        new TwoSum().twoSum(ints, 0);
    }
}
