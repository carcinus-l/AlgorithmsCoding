package com.carcinus.code.leetcode.offer.p_47;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * @link <a href="https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/">...</a>
 */
public class LiWuDeZuiDaJieZhiLcof {

    public int maxValue(int[][] grid) {
//        return dfs(grid, 0, 0, 0);
        return dp(grid, grid.length, grid[0].length);
    }

    /**
     * 二叉树dfs遍历 记录最大值
     * 没有剪枝优化，超时了
     */
    private int dfs(int[][] grid, int x, int y, int value) {
        if (x >= grid.length || y >= grid[0].length) {
            return value;
        }
        value += grid[x][y];

        return Math.max(dfs(grid, x + 1, y, value), dfs(grid, x, y + 1, value));
    }


    /**
     * 动态规划
     * 对于某个位置dp[i][j]的价值v, 它的最大值是它的上一步的最大值加上它本身，
     * 它的上一步可能是dp[i - 1][j] 或者 dp[i] [j - 1]
     * 从出发位顺推即可
     */
    public int dp(int[][] grid, int m, int n) {
        int[][] values = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0 , left = 0;
                if (i - 1 >= 0) {
                    up = values[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = values[i][j - 1];
                }
                values[i][j] = Math.max(up, left) + grid[i][j];
            }
        }
        return values[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LiWuDeZuiDaJieZhiLcof o = new LiWuDeZuiDaJieZhiLcof();
        int[][] params = new int[3][];
        params[0] = new int[]{1,3,1};
        params[1] = new int[]{1,5,1};
        params[2] = new int[]{4,2,1};
        System.out.println(o.maxValue(params));
    }
}
