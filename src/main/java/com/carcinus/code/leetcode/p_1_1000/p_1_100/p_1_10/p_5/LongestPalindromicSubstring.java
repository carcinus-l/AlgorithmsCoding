package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_5;

/**
 * 5. 最长回文子串
 *
 * @link <a href="https://leetcode.cn/problems/longest-palindromic-substring/">...</a>
 * <p>
 * 遍历字符串
 * 双指针遍历每一个位置的回文子串
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }



    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
    }
}
