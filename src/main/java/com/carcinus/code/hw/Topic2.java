package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**

 单词倒序
 简单字符串处理
 按空格切分后注意标点就行了

 */
public class Topic2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            String reverseWord = reverseWord(line);
            System.out.println(reverseWord);
        }
    }

    public static String reverseWord(String s) {
        StringBuffer sb = new StringBuffer();
        String[] words = s.split(" ");
        for (String word : words) {
            sb.append(" ");
            char[] chars = word.toCharArray();
            int index = chars.length - 1;
            char op = ' ';
            if (chars[index] == ',' || chars[index] == '.' || chars[index] == '?') {
                op = chars[index];
                index --;
            }
            while (index >= 0) {
                sb.append(chars[index--]);
            }
            if (op != ' ') {
                sb.append(op);
            }
        }
        return sb.substring(1);

    }

}
