package com.carcinus.code.leetcode.p_2001_3000.p_2437;

/**
 * @link <a href="https://leetcode.cn/problems/best-poker-hand/">...</a>
 */
public class BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {
        int[] rc = new int[14];
        int[] sc = new int[4];
        for (int i = 0; i < 5; i++) {
            //相同的牌计数
            rc[ranks[i]]++;
            //花色计数
            sc[(suits[i] - 'a')]++;
        }
        for (int count : sc) {
            if (count == 5) {
                return "Flush";
            }
        }
        int max = 0;
        for (int count : rc) {
            max = Math.max(count, max);
        }
        if (max >= 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}
