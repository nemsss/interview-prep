package leetcode.medium;

import util.ListNode;

/**
 * Created by cenumah on 2020-01-13
 */
public class Q2 {

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        System.out.println(new Q2().addTwoNumbers(head, head2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            return null;
        }

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(size(l1) < size(l2)) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode node = l1;
        ListNode prev = null;
        int carry = 0;
        while(node != null) {
            int sum = node.data + (l2 == null ? 0 : l2.data) + carry;
            node.data = sum%10;
            carry = sum/10;

            l2 = l2 == null ? l2 : l2.next;
            prev = node;
            node = node.next;
        }

        if(carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverse(l1);

    }

    private ListNode reverse (ListNode head) {

        ListNode prev = null;
        ListNode next;
        ListNode node = head;

        while(node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private int size(ListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
