package com.nextyu.leetcode._0002_Add_Two_Numbers;

import org.junit.Test;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 9)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 965 = 1307.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10; // 进位
            current.next = new ListNode(sum % 10);
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }
        return sb.toString();
    }
}
