package LinkedLists;

/**
 * Created by prateek on 20/05/17.
 */

public class ListNodePairSwap {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNodePairSwap listNodePairSwap = new ListNodePairSwap();
        listNodePairSwap.swapPairs(l).printList();

    }

    public ListNode swapPairs(ListNode a) {
        ListNode prev = null;
        ListNode next = null;
        ListNode x;
        ListNode y;
        ListNode head = a;
        x = a;

        while (x != null && x.next != null) {
            y = x.next;
            next = y.next;

            y.next = x;
            x.next = next;
            if (prev != null)
                prev.next = y;
            else
                head = y;
            prev = x;
            x = next;
        }

        return head;
    }
}