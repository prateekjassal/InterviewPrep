package LinkedLists;

/**
 * Created by prateek on 20/05/17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void printList() {
        ListNode curr = this;
        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}