package com.carcinus.code.leetcode.p_1_100.p_2;

/**
 * 2. 两数相加
 * @link <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 *
 * 直接链表遍历相加
 * 处理进位和长度剩余结点
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(), current = root;
        int bit = 0, t;

        while (l1 != null && l2 != null) {
            t = l1.val + l2.val + bit;
            bit = t / 10;
            current.next = new ListNode(t % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            t = l1.val + bit;
            bit = t / 10;
            current.next = new ListNode(t % 10);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            t = l2.val + bit;
            bit = t / 10;
            current.next = new ListNode(t % 10);
            current = current.next;
            l2 = l2.next;
        }
        if (bit != 0) {
            current.next = new ListNode(bit);
        }
        return root.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l4 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9, new ListNode(9,
                                                        new ListNode(9))))))));

//        ListNode listNode = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(l4, l3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

