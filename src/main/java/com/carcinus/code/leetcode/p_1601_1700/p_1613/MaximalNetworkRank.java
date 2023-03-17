package com.carcinus.code.leetcode.p_1601_1700.p_1613;

/**
 * 1615. 最大网络秩
 *
 * @link <a href="https://leetcode.cn/problems/maximal-network-rank/">...</a>
 * <p>
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数
 * <p>
 * 城市对:两座不同城市
 * 网络秩 : 城市直接相连的道路总数
 * 如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 */
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] cityRoads = new int[n][n];
        int[] roadNumbers = new int[n];
        for (int i = 0; i < roads.length; i++) {
            cityRoads[roads[i][0]][roads[i][1]] = 1;
            cityRoads[roads[i][1]][roads[i][0]] = 1;
            roadNumbers[roads[i][0]]++;
            roadNumbers[roads[i][1]]++;
        }
        int max = 0, maxCity = 0, res = 0;

        for (int i = 0; i < roadNumbers.length; i++) {
            int t = roadNumbers[i];
            if (t >= max) {
                res = t + max;
                if(cityRoads[i][maxCity] == 1) {
                    res--;
                }
                max = t;
                maxCity = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalNetworkRank object = new MaximalNetworkRank();
        System.out.println(object.maximalNetworkRank(4, new int[][]{
                {0,1},{0, 3}, {1, 2}, {1, 3}
        }));
    }
}
