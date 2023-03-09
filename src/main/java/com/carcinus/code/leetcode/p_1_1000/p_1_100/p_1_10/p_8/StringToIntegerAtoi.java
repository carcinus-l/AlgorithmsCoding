package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_8;

import com.carcinus.code.leetcode.run.Runnable;
import com.carcinus.code.leetcode.run.Runner;

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
        //2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        int start = 0, end = 0;
        char op = s.charAt(0);
        if (op == '+' || op == '-') {
            start ++;
        }
        //3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) >= '0' || s.charAt(i) <= '9'){
                end = i;
            }
        }
        //4.将前面步骤读入的这些数字转换为整数。如果没有读入数字，则整数为 0 。必要时更改符号。
        if (end - start == 0) {
            return 0;
        }
        String res = s.substring(start, end + 1);
        if (res)


        return 1;
    }



    public static void main(String[] args) throws Exception {
        StringToIntegerAtoi object = new StringToIntegerAtoi();
//        int i = object.myAtoi("   -42");
//        System.out.println(i);
        int i = (int )Runner.run(StringToIntegerAtoi.class, "-42");
        System.out.println(i);
    }

}
