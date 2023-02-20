package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * *查找单入口空闲区域**
 * 构建二维数组, X用1表示, O用0表示, 特殊的O(既入口)用-1表示
 * 再用一个二维数据visit标记这个坐标是否访问过来防止重复遍历
 * 当一个值为-1的坐标不与另外一个值为-1的坐标间接联通时，就是一个单入口区域
 */
public class Topic6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.split(" ")[0]);
            int m = Integer.parseInt(line.split(" ")[1]);
            int[][] matrix = new int[n][m];
            String[] els = br.readLine().split(" ");
            //第一行
            for (int i = 0; i < els.length; i++) {
                if (els[i].equals("X")) {
                    matrix[0][i] = 1;
                } else {
                    //入口
                    matrix[0][i] = -1;
                }
            }
            for (int i = 1; i < n - 1; i++) {
                els = br.readLine().split(" ");
                if (els[0].equals("X")) {
                    matrix[0][i] = 1;
                }else {
                    //入口
                    matrix[0][i] = -1;
                }
                for (int j = 1; j < els.length - 1; j++) {
                    if (els[0].equals("X")) {
                        matrix[0][i] = 1;
                    }else {
                        //入口
                        matrix[0][i] = 0;
                    }
                }
            }
        }
    }

    public static int judge( String c, int flag) {
        return c.equals("X") ? 1 : flag;
    }

}
