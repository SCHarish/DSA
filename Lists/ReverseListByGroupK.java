public class ReverseListByGroupK {
     class ListNode {
      int val;
      ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static void main(String args[]){
        ReverseListByGroupK obj = new ReverseListByGroupK();
        ListNode head = obj.new ListNode(1);
        ListNode node2 = obj.new ListNode(2);
        ListNode node3 = obj.new ListNode(3);
        ListNode node4 = obj.new ListNode(4);
        ListNode node5 = obj.new ListNode(5);
        
        head.next =node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode newHead = obj.reverseKGroup(head, 3);
        
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        
        int count = 0;
        
        ListNode curr = head, next = head, prev = null;
        
        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null)//next points to k+1th node
        {
            System.out.println("head val "+head.val);
            head.next = reverseKGroup(curr, k);
        
        }
        
       
        return prev;
        
    }
}


