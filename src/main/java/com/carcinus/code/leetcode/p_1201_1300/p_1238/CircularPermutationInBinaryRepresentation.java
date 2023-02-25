package com.carcinus.code.leetcode.p_1201_1300.p_1238;

import java.util.ArrayList;
import java.util.List;

/**
 * @title 1238. 循环码排列
 * @link <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/description/">...</a>
 * 相似题 89.格雷编码
 */
public class CircularPermutationInBinaryRepresentation {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        mirrorArrangement(res, n, start);
        return res;
    }

    /**
     * 鏡射排列
     * **格雷码递归生成码表**
     * 这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
     * * 1位格雷码有两个码字
     * * (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
     * * (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1
     * * n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
     */
    public void mirrorArrangement(List<Integer> res, int n, int start) {
        int len = (int) Math.pow(2, n);
        String[] codes = new String[len];
        codes[0] = "0";
        codes[1] = "1";
        for (int i = 2; i <= n; i++) {
            int r = (int) Math.pow(2, i) - 1;
            int l = 0;
            while (l < r) {
                codes[r] = "1" + codes[l];
                l++;
                r--;
            }
            while (r >= 0) {
                codes[r] = "0" + codes[r];
                r--;
            }
        }
        int[] queue = new int[len];
        for (int i = 0; i < codes.length; i++) {
            queue[i] = Integer.parseInt(codes[i], 2);
        }
        for (int i = 0; i < len; i++) {
            if (queue[i] == start) {
                int index = i;
                while (index < len){
                    res.add(queue[index++]);
                }
                index = 0;
                while (index < i) {
                    res.add(queue[index++]);
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        List<Integer> res = new CircularPermutationInBinaryRepresentation().circularPermutation(2, 3);
        res.forEach(System.out::println);
    }
}
