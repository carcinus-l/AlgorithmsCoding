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
 * 动态规划
 * 一维前缀和的公式：sum[i] = sum[i-1] + arr[i] ; sum是前缀和数组, arr是内容数组。拥有前缀和数组后, 我们可以在O(1)的时间复杂度内求出区间和。
 *
 * [i, j]的区间和公式: interval [i, j] = sum[j] - sum[i - 1]
 *
 *
 */
public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long[] prefixSum = new long[len + 1];
        long total = 0;
        for (int i = 1; i <= len; i++) {
            total += nums[i - 1];
            prefixSum[i] = total;
        }
        if (total < p) {
            return -1;
        } else if (total % p == 0) {
            return 0;
        }

        int l = 1;
        while (l < len) {
            for (int i = 1, j = i + l - 1; j <= len; i++, j++) {
                long t = prefixSum[j] - prefixSum[i - 1];
                if ((total - t) % p == 0){
                    return l;
                }
            }
            l ++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP makeSumDivisibleByP = new MakeSumDivisibleByP();
        System.out.println(makeSumDivisibleByP.minSubarray(
                new int[]{6,3,5,2},
                9
        ));
    }
}
