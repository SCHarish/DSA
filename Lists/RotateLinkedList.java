public class RotateLinkedList {

    class ListNode{
        int val;
        ListNode(int no){
            this.val = no;
            this.next = null;
        }

        ListNode next;
    }
    public static void main(String args[]){
        RotateLinkedList obj = new RotateLinkedList();

        ListNode head = obj.new ListNode(1);
        ListNode node2 = obj.new ListNode(2);
        ListNode node3 = obj.new ListNode(3);
        ListNode node4 = obj.new ListNode(4);
        ListNode node5 = obj.new ListNode(5);
        ListNode node6 = obj.new ListNode(6);
        
        head.next =node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode newHead = obj.rotate(head, 3);
        
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public  ListNode rotate(ListNode head, int k) {
        // add code here
        ListNode newHead = null;
        ListNode oldHead = head;
        
        while(k-1 >0){
            head = head.next;
            k--;
        }
        
        newHead = head.next; //no null check as k is less than or equals to no of nodes
        head.next = null; //assign the next of after k nodes as null

        ListNode ref = newHead;
        
        if(newHead != null){
            while(ref.next != null){
                ref = ref.next;
            }
            
            ref.next = oldHead;
        } else{
            newHead = oldHead;
        }
        
        return newHead;
        
    }

    
}
