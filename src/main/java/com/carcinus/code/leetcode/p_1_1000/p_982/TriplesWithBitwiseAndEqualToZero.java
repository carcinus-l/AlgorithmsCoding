package com.carcinus.code.leetcode.p_1_1000.p_982;

/**
 * 982. 按位与为零的三元组
 * @link <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/">...</a>
 * 按位与 ： 二进制位两个位都为1时，结果才为1
 * 题目要求三个数的按位与为0，即
 * 最大次数为
 */
public class TriplesWithBitwiseAndEqualToZero {

    /**
     * 暴力破解
     *
     * 当三个数按位与为0时，无论怎么排列都会是按位与为 0
     * 复杂度n的三次方， n最大1000， 估计会超时
     *
     *
     */
    public int countTriplets(int[] nums) {
        int len = nums.length, count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                for (int k = j; k < len; k++) {
                    if ((nums[i] & nums[j] & nums[k]) == 0) {
                        count++;
                    }
                }
            }
        }
        return count * 3;
    }

    /**
     * 当三个数
     */
    public int countTriplets2(int[] nums) {

        return 1;
    }


}
