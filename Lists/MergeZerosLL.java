/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

// For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

// Return the head of the modified linked list.

 

// Example 1:


// Input: head = [0,3,1,0,4,5,2,0]
// Output: [4,11]
// Explanation: 
// The above figure represents the given linked list. The modified list contains
// - The sum of the nodes marked in green: 3 + 1 = 4.
// - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
// Example 2:


// Input: head = [0,1,0,3,0,2,2,0]
// Output: [1,3,4]
// Explanation: 
// The above figure represents the given linked list. The modified list contains
// - The sum of the nodes marked in green: 1 = 1.
// - The sum of the nodes marked in red: 3 = 3.
// - The sum of the nodes marked in yellow: 2 + 2 = 4.




public class MergeZerosLL {

    public ListNode mergeNodes(ListNode head) {
        int count = 0;
        ListNode temp = head.next;
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead; // assign new temp head, later we can append new nodes.
        
        while(temp != null){
            while(temp != null && temp.val > 0){
                count += temp.val;
                temp = temp.next;
            }
            
            
            ListNode node = new ListNode(count);
            node.next = null;
            curr.next = node;
            curr = curr.next;
            temp = temp.next;
            count = 0;
        }
        
        
        
        return newHead.next;
        
    }
}
