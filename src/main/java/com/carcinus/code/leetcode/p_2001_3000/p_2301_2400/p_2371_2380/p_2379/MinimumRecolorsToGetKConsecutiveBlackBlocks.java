package com.carcinus.code.leetcode.p_2001_3000.p_2301_2400.p_2371_2380.p_2379;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * @link <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">...</a>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 滑窗， 统计窗口中的W个数，求最小
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k) {
            return 0;
        }
        char[] chars = blocks.toCharArray();
        int start = 0, end = k, w = 0, b = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == 'W') {
                w++;
            } else {
                b++;
            }
        }
        int min = w;
        while (end < blocks.length()) {
            if (chars[start] == 'W') {
                w--;
            } else {
                b--;
            }
            if (chars[end] == 'W') {
                w++;
            } else {
                b++;
            }
            start++;
            end++;
            min = Math.min(w, min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks object = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        System.out.println(object.minimumRecolors("WBBWWBBWBW", 7));
    }
}
