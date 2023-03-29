package com.carcinus.code.leetcode.p_1601_1700.p_1641;

import com.carcinus.code.leetcode.run.Runnable;
import com.carcinus.code.leetcode.run.Runner;

import java.util.Arrays;

/**
 * 1641. 统计字典序元音字符串的数目
 * @link <a href="https://leetcode.cn/problems/count-sorted-vowel-strings/">...</a>
 *
 * a 1  1  1
 * e 1  2  3 ae ee  aee eee 2 + 1
 * i 1  3  6 ai ei ii  ->  aii,eii,iii,aai, aei,eei  3 + 3
 * o 1  4  10 ao, eo io, oo -> 4 + 6
 * u 1  5  15  5 + 10
 *
 */
public class CountSortedVowelStrings {

    @Runnable
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[] nums = new int[5];
        Arrays.fill(nums, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                nums[j] += nums[j - 1];
            }
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        Runner.run(CountSortedVowelStrings.class, 2);
    }
}
