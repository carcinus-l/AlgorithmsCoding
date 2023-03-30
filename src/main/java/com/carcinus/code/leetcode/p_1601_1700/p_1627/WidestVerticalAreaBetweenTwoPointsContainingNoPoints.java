package com.carcinus.code.leetcode.p_1601_1700.p_1627;

import com.carcinus.code.leetcode.run.Runnable;
import com.carcinus.code.leetcode.run.Runner;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1637. 两点之间不包含任何点的最宽垂直区域
 *
 * @link <a href="https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/">...</a>
 * <p>
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> xs = new TreeSet<>();
        int max = 0, pre = Integer.MAX_VALUE;
        for (int[] xys : points) {
            xs.add(xys[0]);
            pre = Math.min(pre, xys[0]);
        }
        for (Integer x : xs) {
            max = Math.max((x - pre), max);
            pre = x;
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int[][] arg = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        new WidestVerticalAreaBetweenTwoPointsContainingNoPoints()
                .maxWidthOfVerticalArea(arg);
    }
}
