package com.carcinus.code.leetcode.p_1_1000.p_464;

/**
 *
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        int[] visits = new int[maxChoosableInteger];
        return dfs(visits, maxChoosableInteger, 0, desiredTotal, 0);
    }

    private boolean dfs(int[] visits, int n, int i, int desiredTotal, int i1) {

        return false;
    }
}
