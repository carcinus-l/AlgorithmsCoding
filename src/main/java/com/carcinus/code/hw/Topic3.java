package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 获得完美走位
 * 平衡字符串的变形问题 力扣1234 替换子串得到平衡字符串
 */
public class Topic3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(balancedString(line));
        }
    }


    public static int balancedString(String s) {
        //完美步数
        int n = s.length() / 4;
        int[] cc = new int[256];
        for (int i = 0; i < s.length(); i++) {
            cc[s.charAt(i)]++;
        }
        if (judge(cc, n)) {
            return 0;
        }
        int res = s.length();
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !judge(cc, n)) {
                cc[s.charAt(r)]--;
                r++;
            }
            if (!judge(cc, n)) {
                break;
            }
            res = Math.min(res, r - l);
            cc[s.charAt(l)]++;
        }
        return res;
    }

    public static boolean judge(int[] cc, int n) {
        if (cc['A'] > n || cc['S'] > n || cc['D'] > n || cc['W'] > n) {
            return false;
        }
        return true;
    }
}
