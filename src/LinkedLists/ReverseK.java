package LinkedLists;

/**
 * Created by prateek on 23/05/17.
 *
 * Source -
 *
 */
public class ReverseK {
    public static void main(String[] args) {
        ReverseK reverseK = new ReverseK();
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next = new ListNode(5);
        reverseK.printList(reverseK.reverseList(listNode, 3));
    }

    public ListNode reverseList(ListNode list, int k) {
        ListNode res = null;
        ListNode curr = list;
        ListNode prev = null;
        ListNode next = null;

        ListNode prevTail = null;
        ListNode head = null;

        int count = 0;
        int iterations = 0;

        while(curr != null) {
            if(count % k == 0) {
                if(head != null)
                prevTail = head;
                head = curr;
                next = curr.next;
                curr.next = null;
                iterations++;
            } else {
//                System.out.printf("Linking %d to %d\n", curr.val, prev.val);
                next = curr.next;
                curr.next = prev;
            }

            if(prevTail != null)
                prevTail.next = curr;

            if(iterations == 1)
            {
                res = curr;
            }
            prev = curr;
            curr = next;
            count++;
        }
        return res;
    }


    private void printList(ListNode l) {
        ListNode curr = l;

        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();

    }
}
