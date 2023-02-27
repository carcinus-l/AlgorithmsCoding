package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_1_10.p_4;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @link <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">...</a>
 * <p>
 * 双指针遍历数组重新排序
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = (nums1.length + nums2.length) / 2;
        int flag = (nums1.length + nums2.length) % 2;
        int[] nums = new int[n + 2];
        for (int i = 0, index1 = 0, index2 = 0; i <= n + 1; i++) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] >= nums2[index2]) {
                    nums[i] = nums2[index2++];
                }else {
                    nums[i] = nums1[index1++];
                }
            } else if (index1 < nums1.length) {
                nums[i] = nums1[index1++];
            } else if (index2 < nums2.length) {
                nums[i] = nums2[index2++];
            }

        }

        if (flag == 1) {
            return nums[n] * 1.0;
        }else {
            return (nums[n] + nums[n - 1] * 1.0) / 2;
        }
    }

    public static void main(String[] args) {
        double medianSortedArrays = new MedianOfTwoSortedArrays()
                .findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }
}
