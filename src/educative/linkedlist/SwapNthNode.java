package educative.linkedlist;

import util.ListNode;

/**
 * Created by cenumah on 2019-12-20
 */
public class SwapNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(swap_nth_node(head, 3));
    }

    static ListNode swap_nth_node(ListNode head, int n) {
        //TODO: Write - Your - Code
        if(head == null) {
            return null;
        }

        int idx = 1;
        ListNode curr = head;
        while(idx++ < n-1 && curr!= null) {
            curr = curr.next;
        }

        if(curr == null || curr.next == null) {
            return head;
        }

        ListNode target = curr.next;
        ListNode next = head.next;

        curr.next = head;
        head.next = target.next;
        target.next = next;

        return target;
    }
}
