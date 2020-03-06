package util;

/**
 * Created by cenumah on 2019-12-17
 */
public class ListNode {

    public int data;
    public ListNode next;
    public ListNode prev;

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data + " - " + this.next;
    }
}
