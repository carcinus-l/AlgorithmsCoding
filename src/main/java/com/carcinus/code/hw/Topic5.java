package com.carcinus.code.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 方法一：暴力破解
 * 两层for循环求最小位置到最大位置的每个位置的结果取最小
 * 家庭数一多百分百超时
 * 方法二：数学推导
 * 假设学校在位置x时与各家庭的距离之和为**f(x)**,在位置y的家庭与位置x学校距离为**g(y)**
 * 当学校在位置x时左边有l1,l2,l3...ln共**n**个家庭.
 * 当学校在位置x时左边有r1,r2,r3...rm共**m**个家庭.
 * 所以**f(x)=g(l1) + g(l2) + g(l3) + ... + g(ln) + g(r1) + g(r2) + g(r3) + ... + g(rm)**
 * 如果学校位置往左移一个位置，既 x - 1时
 * 左边每个家庭与学校的距离都 - 1, n个家庭就是 - n
 * 右边每个家庭与学校的距离都 + 1, m个家庭就是 + m
 * 所以**f(x - 1) = f(x) - n + m**
 * 同理往有移可得**f(x + 1) = f(x) + n - m**
 * <p>
 * 对于n和m有三种情况：
 * 当 n < m 时：
 * f(x - 1) > f(x)
 * f(x + 1) < f(x)
 * 所以当n < m时需要往右移
 * 当 n > m 时：
 * f(x - 1) < f(x)
 * f(x + 1) > f(x)
 * 所以当n > m时需要往左移
 * 当 n = m 时:
 * f(x - 1) = f(x)
 * f(x + 1) = f(x)
 * 所以当n = m 时, 左移和右移都不会增大f(x)
 * <p>
 * 所以学校的位置就是对所有家庭位置排序之后的中位数.
 * ps:当家庭总数为偶数时 取小的
 */
public class Topic5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int[] nums = new int[n + 1];
            String[] indexes = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(indexes[i - 1]);
            }
            Arrays.sort(nums);
            System.out.println(nums[n / 2]);
        }
    }


}
