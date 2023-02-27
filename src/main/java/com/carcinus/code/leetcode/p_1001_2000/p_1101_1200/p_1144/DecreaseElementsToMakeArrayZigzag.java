package com.carcinus.code.leetcode.p_1001_2000.p_1101_1200.p_1144;

/**
 * 1144. 递减元素使数组呈锯齿状
 *
 * @link <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/">...</a>
 * <p>
 * 因为每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 隐含意思就是不能对元素增加
 *
 * 不管是奇数还是偶数，都是只需要跟前一位对比即可
 */
public class DecreaseElementsToMakeArrayZigzag {

    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int pre1 = nums[0], pre2 = nums[0], c1 = 0, c2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            if (i % 2 == 1) {
                if (t <= pre1) {
                    int gap = pre1 - t + 1;
                    c1 += gap;
                }
                pre1 = t;
                if (t >= pre2) {
                    int gap = t - pre2 + 1;
                    pre2 = t - gap;
                    c2 += gap;
                } else {
                    pre2 = t;
                }
            } else {
                if (t >= pre1) {
                    int gap = t - pre1 + 1;
                    pre1 = t - gap;
                    c1 += gap;
                } else {
                    pre1 = t;
                }
                if (t <= pre2) {
                    int gap = pre2 - t + 1;
                    c2 += gap;

                }
                pre2 = t;
            }

        }
        return Math.min(c1, c2);
    }


    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {9, 6, 1, 6, 2};
        System.out.println(new DecreaseElementsToMakeArrayZigzag().movesToMakeZigzag(nums));
    }

}
