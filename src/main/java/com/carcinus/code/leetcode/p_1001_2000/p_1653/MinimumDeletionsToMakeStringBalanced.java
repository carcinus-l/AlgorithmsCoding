package com.carcinus.code.leetcode.p_1001_2000.p_1653;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1653. 使字符串平衡的最少删除次数
 *
 * @link <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">...</a>
 *
 *
 */
public class MinimumDeletionsToMakeStringBalanced {

    //超时了
//    public int minimumDeletions(String s) {
//        int count = 0;
//        while (s.contains("ba")) {
//            count++;
//            s = s.replaceFirst("ba", "");
//        }
//
//        return count;
//    }

    /**
     * 动态规划
     *  通过删除部分字符串，使得字符串达到下列三种情况之一，即为平衡状态：
     *
     * 字符串全为 “a”
     * 字符串全为 “b”
     * 字符串既有 “a” 也有 “b”，且所有 “a”都在所有 “b” 左侧。
     *
     * 其中，为了达到第 1 种情况，最少需要删除所有的 “b”。为了达到第 2 种情况，最少需要删除所有的 “a”。而第 333 种情况，可以在原字符串相邻的两个字符之间划一条间隔，删 除间隔左侧所有的 “b” 和间隔右侧所有的 “a” 即可达到。用 leftb 表示间隔左侧的 “b”的数目，righta 表示间隔左侧的 “a”的数目，leftb+righta 即为当前划分的间隔下最少需要删除的字符数
     */
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }



    public static void main(String[] args) throws IOException {
        MinimumDeletionsToMakeStringBalanced o = new MinimumDeletionsToMakeStringBalanced();
//        System.out.println(o.minimumDeletions("aababbab"));
        FileInputStream fis = new FileInputStream("src/main/java/com/carcinus/code/leetcode/p_1001_2000/p_1653/case.text");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String s = null;
        while ((s = br.readLine())!= null) {
            long start = System.currentTimeMillis();
            System.out.println("len = " + s.length());
            System.out.println("res = " + new MinimumDeletionsToMakeStringBalanced().minimumDeletions(s));
            long end = System.currentTimeMillis();
            System.out.println("time = " + (end - start));
        }
    }
}
