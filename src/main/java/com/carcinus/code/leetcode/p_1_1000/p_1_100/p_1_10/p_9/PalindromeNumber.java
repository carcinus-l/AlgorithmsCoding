package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_9;

/**
 *  9. 回文数
 * @link <a href="https://leetcode.cn/problems/palindrome-number/">...</a>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
//        int l = 0, r = s.length()- 1;
//        while (r >= 0 && l< s.length()) {
//            if (s.charAt(l) != s.charAt(r)) {
//                return false;
//            }
//            l++;
//            r--;
//        }
       return new StringBuffer(s).reverse().toString().equals(s);
//        return true;
    }
}
