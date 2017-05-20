package Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prateek on 20/05/17.
 */

public class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.set(4, 4);
        System.out.println(lruCache.get(2));
        lruCache.set(5, 5);
        System.out.println(lruCache.get(5));

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Dummy head for the list
        head = new ListNode(-1, -1);
        tail = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            // Step 1. Break the node free from it's current position and update tail if needed
            removeNodeFromList(node);
            // Step 2. Push it next to the head of the list
            pushNodeNextToHead(node);
            // printList();
            return node.val;
        }
        // printList();
        return -1;
    }

    public void set(int key, int value) {
        ListNode node;
        // If a new key is pushed
        if(!map.containsKey(key)) {
            node = new ListNode(key, value);
            if(map.size() == capacity) {
                evictTailNode();
            }
            map.put(key, node);
        } else {
            // If an existing key is set again
            node = map.get(key);
            // Update the value
            node.val = value;
            // Remove node from list
            removeNodeFromList(node);
        }
        pushNodeNextToHead(node);
        // printList();
    }

    /**
     *
     * Severes the node from the list and updates the tail pointer
     *
     * @param node
     */
    private void removeNodeFromList(ListNode node) {
        // Break the node free from it's current position
        node.prev.next = node.next;
        // If it is not the tail
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            // Update the tail
            tail = node.prev;
        }
    }

    /**
     * Pushes the node next to the head and updates tail pointer
     *
     * @param node
     */
    private void pushNodeNextToHead(ListNode node) {
        // Head can't be null as -1th node won't be evicted ever
        ListNode chain = head.next;
        head.next = node;
        // Node can't be null
        node.prev = head;
        node.next = chain;
        if(chain != null) {
            chain.prev = node;
        } else {
            tail = node;
        }
    }

    /**
     *  Evicts the tail node (least recent) and updates tail pointer
     */
    private void evictTailNode() {
        // Evict least recent node
        ListNode evictedNode = tail;
        tail = tail.prev;
        tail.next = null;
        map.remove(evictedNode.key);
//        System.out.println("Evicted the node: "+evictedNode.key);
    }


    public void printList() {
        ListNode l = head;
        if(tail.key != -1) {
            while(l!=null) {
                System.out.print(l.key+", ");
                l = l.next;
            }
            System.out.println("Tail is "+tail.key);
            System.out.println("Map is "+map);
        } else {
            System.out.println("Empty List");
        }
    }


    class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int val;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return String.format("Key=%s, Value=%s", key, val);
        }
    }
}
