package com.carcinus.code.leetcode.p_1_1000.p_1_100.p_21_30.p_21;

/**
 * 21. 合并两个有序链表
 * @link <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">...</a>
 *
 * 每次判断头元素大小依次插入即可
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode c1 = list1, c2 = list2, res = new ListNode(), current = res;

        while (c1 != null && c2 != null) {
            if (c1.val > c2.val) {
                current.next = c2;
                c2 = c2.next;
            }else {
                current.next = c1;
                c1 = c1.next;
            }
            current = current.next;
        }
        if (c1 != null ){
            current.next = c1;
        }
        if (c2 != null) {
            current.next = c2;
        }
        return res.next;
    }
}
