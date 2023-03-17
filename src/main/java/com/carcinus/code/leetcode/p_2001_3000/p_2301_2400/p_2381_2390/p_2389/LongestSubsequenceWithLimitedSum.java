package com.carcinus.code.leetcode.p_2001_3000.p_2301_2400.p_2381_2390.p_2389;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 *
 * @link <a href="https://leetcode.cn/problems/longest-subsequence-with-limited-sum/">...</a>
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 */
public class LongestSubsequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            res[i] = answerOne(nums, queries[i]);
        }
        return res;
    }

    private int answerOne(int[] nums, int query) {
        int res = 0, total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total <= query) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }
}
