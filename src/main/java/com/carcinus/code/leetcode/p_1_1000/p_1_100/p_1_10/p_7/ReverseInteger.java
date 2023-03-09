package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_7;

import java.util.Arrays;

/**
 * 7. 整数反转
 * @link <a href="https://leetcode.cn/problems/reverse-integer/">...</a>
 * 转化成字符串来反转
 * 然后判断一下范围
 */
public class ReverseInteger {
    public int reverse(int x) {
        int t = Math.abs(x);
        StringBuffer sb = new StringBuffer(String.valueOf(t));
        if (x < 0) {
            sb.append("-");
        }
        String xs = sb.reverse().toString();

        int res = 0;
        try {
            res = Integer.parseInt(xs);
        }catch (NumberFormatException e){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
