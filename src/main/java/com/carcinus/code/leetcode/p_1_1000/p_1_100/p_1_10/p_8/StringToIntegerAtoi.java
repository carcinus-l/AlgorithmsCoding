package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_8;

import com.carcinus.code.leetcode.run.Runnable;
import com.carcinus.code.leetcode.run.Runner;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @link <a href="https://leetcode.cn/problems/string-to-integer-atoi/">...</a>
 * <p>
 * <p>
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class StringToIntegerAtoi {

    @Runnable()
    public int myAtoi(String s) {
        //1.前导空格
        s = s.trim();
        if (s.equals("")){
            return 0;
        }
        //2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。

        int start = 0, end = 0;
        char op = s.charAt(0);
        if (op == '+' || op == '-') {
            start ++;
        }
        //前导0！！！！！！！
        while (start < s.length()) {
            if (s.charAt(start) == '0') {
                start ++;
            }else {
                break;
            }
        }
        end = start;
        //3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                end ++;
            }else {
                break;
            }
        }
        //4.将前面步骤读入的这些数字转换为整数。如果没有读入数字，则整数为 0 。必要时更改符号。
        if (end - start == 0) {
            return 0;
        }

        String res = s.substring(start, end);
        if (res.length() > 10) {
            return op == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (res.length() ==  10 && res.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
            return op == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (op == '-'){
            res = op + res;
        }

        return Integer.parseInt(res);
    }



    public static void main(String[] args) throws Exception {
        StringToIntegerAtoi object = new StringToIntegerAtoi();
        ArrayList<String> params = new ArrayList<>();
        System.out.println("2147483646".compareTo(String.valueOf(Integer.MAX_VALUE)));
        System.out.println("42".compareTo(String.valueOf(Integer.MAX_VALUE)));
        params.add("42");
        params.add("   -42");
        params.add("4193 with words");
        params.add("words and 987");
        params.add("+-12");
        params.add("3.14159");
        params.add("");
        params.add("20000000000000000000");
        params.add("-91283472332");
        params.add("2147483646");
        params.add("0000000000012345678");
        params.add("-2147483647");
        params.forEach(param -> {
            int i = 0;
            try {
                i = (int ) Runner.run(StringToIntegerAtoi.class, param);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        });
    }

}
