package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_11_20.p_13;

import java.util.Stack;

/**
 *13. 罗马数字转整数
 * @link <a href="https://leetcode.cn/problems/roman-to-integer/">...</a>
 *  因为低位放在左边代表减，右边代表加
 *  从后往前遍历 遇到优先级比后一位低的就减掉
 */
public class RomanToInt {

    public int romanToInt(String s) {

        int res = 0, pre = 0;
        int[] values = new int[]{0, 1, 5, 10, 50, 100, 500, 1000};
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = hex(s.charAt(i));
            if (t < pre) {
                res -= values[t];
            }else {
                res += values[t];
            }
            pre = t;
        }
        return res;
    }

    /**
     * 1    I             1
     * 2    V             5
     * 3    X             10
     * 4    L             50
     * 5    C             100
     * 6    D             500
     * 7    M             1000
     */
    public int hex(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 2;
            case 'X': return 3;
            case 'L': return 4;
            case 'C': return 5;
            case 'D': return 6;
            case 'M': return 7;
            default:
                return 0;
        }
    }
}
