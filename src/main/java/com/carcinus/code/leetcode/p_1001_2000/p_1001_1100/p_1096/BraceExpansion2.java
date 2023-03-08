package com.carcinus.code.leetcode.p_1001_2000.p_1001_1100.p_1096;

import java.util.*;

/**
 * 1096. 花括号展开 II
 * @link <a href="https://leetcode.cn/problems/brace-expansion-ii/">...</a>
 *
 * 输出中 不应 出现重复的组合结果。
 * 1 <= expression.length <= 60
 * expression[i] 由 '{'，'}'，',' 或小写英文字母组成
 * 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 *
 *
 *
 */
public class BraceExpansion2 {

    private TreeSet<String> s = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            s.add(exp);
            return;
        }
        int i = j;
        while (exp.charAt(i) != '{') {
            --i;
        }
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        //遍历括号内的每个元素
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }

    public static void main(String[] args) {
        BraceExpansion2 braceExpansion2 = new BraceExpansion2();
        braceExpansion2.braceExpansionII("{{a,z},a{b,c},{ab,z}}")
                .forEach(System.out::println);
    }

}
