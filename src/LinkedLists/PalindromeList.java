package LinkedLists;

import java.util.Stack;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/palindrome-list/
 */
public class PalindromeList {
    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        if( A == null)
            return 0;

        if(A.next == null)
            return 1;

        while(fast.next!= null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        ListNode n2 = prev;
        ListNode n1 = A;
        // System.out.println(n1.val+" "+n2.val);
        while(n1 != null && n2 != null) {
            if(n1.val != n2.val)
                return 0;
            n1 = n1.next;
            n2 = n2.next;
        }

        return 1;
        // 1 2 3 4 5


        // 1
        // 1 2
        // 1 2 1

    }
}
