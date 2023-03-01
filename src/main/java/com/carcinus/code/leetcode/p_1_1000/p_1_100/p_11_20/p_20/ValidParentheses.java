package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_11_20.p_20;

import java.util.Stack;

/**
 * 20. 有效的括号
 * @link <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 *
 *  栈应用
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> ct = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                ct.push(c);
            }else {
                if (ct.isEmpty()){
                    return false;
                }
                Character top = ct.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                    return false;
                }
            }
        }
        return ct.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses o = new ValidParentheses();
        String[] ss = {"()", "()[]{}", "(]"};
        for (String s : ss) {
            System.out.println(o.isValid(s));
        }
    }
}
