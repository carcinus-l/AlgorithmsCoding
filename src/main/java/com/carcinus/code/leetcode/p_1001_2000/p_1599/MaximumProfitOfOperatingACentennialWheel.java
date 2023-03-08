package com.carcinus.code.leetcode.p_1001_2000.p_1599;

/**
 * 1599. 经营摩天轮的最大利润
 *
 * @link <a href="https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/description/">...</a>
 * <p>
 * 题目描述极其不准确，
 * 当等待人数为0的时候，不能停下来
 * 带最后的客户上摩天轮之后就不管了
 */
public class MaximumProfitOfOperatingACentennialWheel {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int count = 0, wait = 0, total = 0, maxCount = 0, maxTotal = 0;
        for (int i = 0; i < customers.length; i++) {
            count++;
            wait += customers[i];
            int currentCustomers = Math.min(wait, 4);
            wait -= currentCustomers;
            total += currentCustomers * boardingCost - runningCost;
            if (total > maxTotal) {
                maxCount = count;
                maxTotal = total;
            }
        }
        while (wait > 0) {
            count++;
            int currentCustomers = Math.min(wait, 4);
            wait -= currentCustomers;
            total += currentCustomers * boardingCost - runningCost;
            if (total > maxTotal) {
                maxCount = count;
                maxTotal = total;
            }
        }


        if (maxTotal <= 0) {
            return -1;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumProfitOfOperatingACentennialWheel o = new MaximumProfitOfOperatingACentennialWheel();
        System.out.println(o.minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }
}
