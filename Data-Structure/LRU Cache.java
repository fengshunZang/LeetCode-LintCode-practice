/*
  Problem Description: Design and implement a data structure for Least Recently Used (LRU) cache.
  It should support the following operations: get and set.
  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
  set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
  it should invalidate the least recently used item before inserting a new item.
*/
public class Solution {
    //Construct a doubly linked list node class
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }
        
        //remove current
        Node current = hashmap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        //move current to tail
        moveToTail(current);
        
        return hashmap.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {
            hashmap.get(key).value = value;
            return;
        }
        
        if (hashmap.size() == capacity) {
            hashmap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        hashmap.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
