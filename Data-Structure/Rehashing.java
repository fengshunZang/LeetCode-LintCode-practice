/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 *Problem Description: The size of the hash table is not determinate at the very beginning.
 * If the total size of keys is too large (e.g. size >= capacity / 10), we should double the 
 * size of the hash table and rehash every keys. 
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable.length == 0) {
          return hashTable;
        }
        
        int newCapacity = 2 * hashTable.length;
        ListNode[] newHashTable = new ListNode[newCapacity];
        
        for (int i = 0; i < hashTable.length; i++) {
            while(hashTable[i] != null) {
                int newIndex = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                // Function: a % b = (a % b + b) % b  is used to make hash code a non negative integer.
                if (newHashTable[newIndex] == null) {
                    newHashTable[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode head = newHashTable[newIndex];
                    while(head.next != null) {
                        head = head.next;
                    }
                    head.next = new ListNode(hashTable[i].val);
                }
                 hashTable[i] = hashTable[i].next;
            }
        }
        
        return newHashTable;
    }
};
