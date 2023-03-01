package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_11_20.p_14;

/**
 * 14. 最长公共前缀
 * @link <a href="https://leetcode.cn/problems/longest-common-prefix/">...</a>
 *
 *  选取长度最短的字符串, 长度逐渐递增求前缀
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String minStr = strs[0];
        for (String s: strs) {
            if (s.length() < minStr.length()) {
                minStr = s;
            }
        }
        for (int i = 0; i < minStr.length(); i++) {

            char c = minStr.charAt(i);
            for (String str : strs) {
                if (i > str.length() || str.charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"f", "ff"}));
    }
}
