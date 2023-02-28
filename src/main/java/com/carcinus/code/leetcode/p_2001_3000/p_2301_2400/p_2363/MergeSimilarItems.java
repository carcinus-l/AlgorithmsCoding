package com.carcinus.code.leetcode.p_2001_3000.p_2301_2400.p_2363;

import java.util.*;

/**
 * 2363. 合并相似的物品
 * @link <a href="https://leetcode.cn/problems/merge-similar-items/">...</a>
 * 哈希
 * kv 合并
 */
public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        int[] bits = new int[1001];
        for (int i = 0; i < items1.length; i++) {
            bits[items1[i][0]] += items1[i][1];
        }
        for (int i = 0; i < items2.length; i++) {
            bits[items2[i][0]] += items2[i][1];
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0) {
                res.add(Arrays.asList(i, bits[i]));
            }
        }
        return res;
    }

}
