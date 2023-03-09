package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_6;


import java.util.ArrayList;
import java.util.List;

/**
 * 6. N 字形变换
 *
 * @link <a href="https://leetcode.cn/problems/zigzag-conversion/description/">...</a>
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        String[] res = new String[numRows];
        for (int i = 0; i < numRows; i++) res[i] = "";
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            res[i] += c;
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        return String.join("", res);
    }
}
