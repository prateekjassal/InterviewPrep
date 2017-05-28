package Graphs;

import LinkedLists.ListNode;

/**
 * Created by prateek on 28/05/17.
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode start) {
        if (start == null)
            return null;
        ListNode[] list = getMid(start);
        ListNode mid = list[1];
        TreeNode root = new TreeNode(mid.val);
        ListNode before = list[0];
        root.left = sortedListToBST(before);
        ListNode after = list[2];
        root.right = sortedListToBST(after);
        return root;
    }

    public ListNode[] getMid(ListNode start) {
        ListNode slow = start;
        ListNode fast = start;
        ListNode prev = null;
        ListNode[] list = new ListNode[3];

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = null;
            list[0] = start;
        } else {
            list[0] = null;
        }

        ListNode mid = slow;
        list[1] = mid;
        list[2] = mid.next;
        mid.next = null;
        return list;
    }
}