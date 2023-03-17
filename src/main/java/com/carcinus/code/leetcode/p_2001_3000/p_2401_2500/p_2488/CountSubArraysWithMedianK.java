package com.carcinus.code.leetcode.p_2001_3000.p_2401_2500.p_2488;

import java.util.HashMap;
import java.util.Map;

/**
 * 2488. 统计中位数为 K 的子数组
 *
 * @Link <a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">...</a>
 * 将数组中严格大于k的数字更改为1，将严格小于k的数字更改为-1，将k更改为0。
 * 中位数为k的数组在新数组中的和应等于0或1，并且应包含元素k。
 *
 */
public class CountSubArraysWithMedianK {

    public int countSubarrays(int[] nums, int k) {
        //前缀和加快计算速度
        int index = 0, res = 0, sum = 0;
        Map<Integer, Integer> bits = new HashMap<>();
        bits.put(0, 1);
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            int judge = judge(nums[i], k);
            if(flag && judge == 0) {
                flag = false;
            }
            sum += judge;
            if (flag) {
                bits.put(sum, bits.getOrDefault(sum, 0) + 1);
            }else {
                res += bits.getOrDefault(sum, 0) + bits.getOrDefault(sum - 1, 0);
            }
        }
        return res;
    }

    public int judge(int n, int k) {
        if (n == k) {
            return 0;
        }else {
            return n > k ? 1 : -1;
        }
    }


    public static void main(String[] args) {
        CountSubArraysWithMedianK object = new CountSubArraysWithMedianK();
        System.out.println(object.countSubarrays(
                new int[]{3, 2, 1, 4, 5},
                4
        ));
    }
}
