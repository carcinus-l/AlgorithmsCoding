package com.carcinus.code.leetcode.p_1001_2000.p_1326;

/**
 1326. 灌溉花园的最少水龙头数目
 @link https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/

 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {


    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            rightMost[start] = Math.max(rightMost[start], end);
        }
        int last = 0, ret = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
