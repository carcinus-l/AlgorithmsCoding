package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 任务混部
 因为没有限制结束时间，所以只需要取最大并行度

 */
public class Topic1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int max = 0;
            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine().split(" ")[2]);
                max = Math.max(max, m);
            }
            System.out.println(max);
        }
    }

}
