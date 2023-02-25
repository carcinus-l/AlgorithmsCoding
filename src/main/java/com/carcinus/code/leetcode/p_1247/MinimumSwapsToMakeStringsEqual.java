package com.carcinus.code.leetcode.p_1247;

/**
 * 1247. 交换字符使得字符串相同
 *
 * @link <a href="https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/">...</a>
 */
public class MinimumSwapsToMakeStringsEqual {

    public int minimumSwap(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            //清理不需要换位置的
            if (c1 != c2) {
                if (c1 == 'x') {
                    x1++;
                } else {
                    y1++;
                }
                if (c2 == 'x') {
                    x2++;
                } else {
                    y2++;
                }
            }
        }
        if (((x1 + x2) % 2 == 1) || ((y1 + y2) % 2 == 1)) {
            return -1;
        }
        int total = 0;
        //处理xx和yy的情况
        while ((x1 >= 2 && y2 >= 2)) {
            total++;
            x1 -= 2;
            y2 -= 2;
        }
        while ((x2 >= 2 && y1 >= 2)) {
            total++;
            x2 -= 2;
            y1 -= 2;
        }
        //处理xy和yx的情况
        if (x1 != 0 || y1 != 0) total += 2;
        return total;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToMakeStringsEqual().minimumSwap("xx", "yy"));
        System.out.println(new MinimumSwapsToMakeStringsEqual().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}
