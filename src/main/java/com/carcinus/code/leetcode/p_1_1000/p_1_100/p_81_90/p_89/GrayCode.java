package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_81_90.p_89;

import java.util.ArrayList;
import java.util.List;

/**
 * @title 89. 格雷编码
 * @link <a href="https://leetcode.cn/problems/gray-code/description/">...</a>
 * @link <a href="https://zh.wikipedia.org/zh/%E6%A0%BC%E9%9B%B7%E7%A0%81">格雷码</a>
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
//        directArrangement(res, n);
//        mirrorArrangement(res, n);

        return res;
    }

    /**
     * 直接排列法
     * 以二進制為0值的格雷碼為第零項，第一項改變最右邊的位元，第二項改變右起第一個為1的位元的左邊位元，第三、四項方法同第一、二項，如此反覆，即可排列出n個位元的格雷碼。
     */
    public void directArrangement(List<Integer> res, int n) {
        int edge = (int) (Math.pow(2, n));
        char[] cs = new char[n + 1];
        for (int i = 0; i <= n; i++) {
            cs[i] = '0';
        }
        boolean flag = true;
        for (int i = 0; i < edge; i++) {
            res.add(Integer.parseInt(String.valueOf(cs), 2));
            if (flag) {
                cs[n] = cs[n] == '0' ? '1' : '0';
                flag = false;
            } else {
                int index = n;
                while (index > 1 && cs[index] != '1') {
                    index--;
                }
                cs[index - 1] = cs[index - 1] == '0' ? '1' : '0';
                flag = true;
            }
        }
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
    public void mirrorArrangement(List<Integer> res, int n) {
        String[] codes = new String[(int) Math.pow(2, n)];
        codes[0] = "0";
        codes[1] = "1";
        for (int i = 2; i <= n; i++) {
            int end = (int) Math.pow(2, i) - 1;
            int start = 0;
            while (start < end) {
                codes[end] = "1" + codes[start];
                start++;
                end--;
            }
            while (end >= 0) {
                codes[end] = "0" + codes[end];
                end--;
            }
        }
        for (String code : codes) {
            res.add(Integer.parseInt(code, 2));
        }
    }

    public static void main(String[] args) {
        List<Integer> res = new GrayCode().grayCode(3);
        res.forEach(System.out::println);
    }

}
