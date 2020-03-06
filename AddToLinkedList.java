package others;

import util.ListNode;

import java.util.Stack;

/**
 * Created by cenumah on 2020-01-13
 */
public class AddToLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        System.out.println(addOne(head, 3));

        head = new ListNode(4);
        head.next = new ListNode(9);
        head.next.next = new ListNode(4);
        System.out.println(addOne(head, 9));

        head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        System.out.println(addOne(head, 9));
    }



    private static ListNode addOne(ListNode head, int toAdd) {

        if(head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while ( node != null) {
            stack.add(node);
            node = node.next;
        }

        while(!stack.isEmpty()) {
            node = stack.pop();
            int newVal = node.data + toAdd;
            node.data = newVal%10;
            toAdd = newVal/10;
        }

        if(toAdd > 0) {
            head = new ListNode(toAdd, head);
        }

        return head;
    }
}
