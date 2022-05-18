// Input:
// N = 8
// value[] = {1,2,2,1,2,0,2,2}
// Output: 0 1 1 2 2 2 2 2
// Explanation: All the 0s are segregated
// to the left end of the linked list,
// 2s to the right end of the list, and
// 1s in between.

public class Sort0s1s2s {
    public static void main(String args[]){
        Sort0s1s2s obj = new Sort0s1s2s();
        Node head = obj.new Node();

    }


    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    static Node segregate(Node head)
    {
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        
        Node zero = zeroHead, one = oneHead, two = twoHead;
        while(head != null){
            if(head.data == 0){
                zero.next = head;
                zero = zero.next;
            } else if(head.data == 1){
                one.next = head;
                one = one.next;
            } else{
               two.next = head;
               two = two.next;
            }
            
            head = head.next;
        }
        
        zero.next = (oneHead.next != null) ? (oneHead.next) : (twoHead.next);
        
        
        one.next = twoHead.next;
        
       
        two.next = null;
     
        return zeroHead.next;
        // add your code here
    }

}
