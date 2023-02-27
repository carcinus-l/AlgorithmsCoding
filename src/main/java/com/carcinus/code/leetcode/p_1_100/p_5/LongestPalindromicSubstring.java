package com.carcinus.code.leetcode.p_1_100.p_5;

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

        int max = 0, start = 0, end = s.length(), l, r;
        for (int i = 1; i < s.length() - 1; i++) {
            l = i;
            r = i;
            if (s.charAt(i) == s.charAt(i + 1)) {
                r++;
            }
            if (s.charAt(i) == s.charAt(i - 1)) {
                l--;
            }
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    int t = r - l;
                    if (max < t) {
                        max = t;
                        start = l;
                        end = r;
                    }

                    break;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaba1"));
    }
}
