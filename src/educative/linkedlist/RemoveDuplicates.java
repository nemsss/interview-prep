package educative.linkedlist;

import util.ListNode;

/**
 * Created by cenumah on 2019-12-17
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        System.out.println(removeDuplicates(removeDuplicates(head)));

        head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        System.out.println(sortList_Merge(head));
    }

    private static ListNode removeDuplicates(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        head = sortList_Bubble(head);

        ListNode node = head;
        while(node != null) {
            if(node.next != null && node.data == node.next.data) {
                node.next = node.next.next;
            }
            node = node.next;
        }

        return head;
    }

    private static ListNode sortList_Merge(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode secondHalf = mid.next;

        mid.next = null;

        head = sortList_Merge(head);
        secondHalf = sortList_Merge(secondHalf);

        return merge(head, secondHalf);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode res = new ListNode();
        ListNode node = res;

        while(true) {
            if(l1 == null) {
                node.next = l2;
                break;
            }

            if(l2 == null) {
                node.next = l1;
                break;
            }

            if(l1.data < l2.data) {
                node.next = new ListNode(l1.data);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.data);
                l2 = l2.next;
            }

            node = node.next;
        }

        return res.next;
    }

    private static ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        int size = 0;
        while(node != null) {
            size++;
            node = node.next;
        }

        node = head;
        int count = 1;
        while(count++ < size/2) {
            node = node.next;
        }

        return node;

    }

    private static ListNode sortList_Bubble(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        int size = 0;
        ListNode node = head;
        while(node != null) {
            size++;
            node = node.next;
        }

        node = head;
        int itr = 0;
        while(itr++ < size) {
            boolean swapped = false;
            while(node != null ) {
                if(node.next != null && node.next.data < node.data) {
                    int data = node.data;
                    node.data = node.next.data;
                    node.next.data = data;
                    swapped = true;
                }
                node = node.next;
            }

            if(!swapped) break;
            node = head;
        }

        return head;
    }
}
