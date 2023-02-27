package com.carcinus.code.leetcode.p_1_100.p_3;

/**
 * 3. 无重复字符的最长子串
 *
 * @link <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">...</a>
 *
 *  暴力遍历
 *  bit位图存是否遇到
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] bits;
        int max = 0 ;
        for (int i = 0; i < s.length(); i++) {
            bits = new int[256];
            int tmp = 1;
            bits[s.charAt(i)]++;
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (bits[c] == 0) {
                    bits[c]++;
                    tmp++;
                }else {
                    max = Math.max(max, tmp);
                    break;
                }
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
//                .lengthOfLongestSubstring("abcabcbb"));
                .lengthOfLongestSubstring(" "));
    }
}
