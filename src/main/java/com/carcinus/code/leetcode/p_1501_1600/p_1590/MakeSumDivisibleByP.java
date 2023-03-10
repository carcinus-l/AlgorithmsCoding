package com.carcinus.code.leetcode.p_1501_1600.p_1590;

/**
 * 1590. 使数组和能被 P 整除
 * @link <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/description/">...</a>
 *
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 * （n1+n2+n3 + ... + nn）% p == 0
 *
 */
public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        int[] bits = new int[p + 1];
        int total = 0;
        for (int num : nums) {
            bits[num % p]++;
            total += p;
        }

        if (total < p) {
            return -1;
        } else if (total % p == 0) {
            return 0;
        }
        int res = 0, l = 1, r = p - 1;
        while (l <= r) {
            int min = Math.min(bits[l], bits[r]);
            res += min;
        }

    }
}
