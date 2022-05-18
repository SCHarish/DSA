public class FlattenLL {

    class ListNode {
        int val;
        ListNode next;
        ListNode child;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String args[]){
        FlattenLL obj = new FlattenLL();
        ListNode head = obj.new ListNode(1);
        ListNode node2 = obj.new ListNode(2);
        ListNode node3 = obj.new ListNode(3);
        ListNode node4 = obj.new ListNode(4);
        ListNode node5 = obj.new ListNode(5);
        
        head.next = node2;
        node2.next = node3;
        

        ListNode node10  = obj.new ListNode(10);
        node10.next = null;

        ListNode node9 = obj.new ListNode(9);
        node9.next = node10;
        

        ListNode node12 = obj.new ListNode(12);
        node12.next = null;

        ListNode node11 = obj.new ListNode(11);
        node11.next = node12;

        ListNode node8 = obj.new ListNode(8);
        node8.child = node11;
        node8.next = node9;
        

        ListNode node7 = obj.new ListNode(7);
        node7.next = node8;

        node3.next = node4;
        node3.child = node7;

        node4.next = node5;
        node5.next = null;



        obj.recurList(head);
    }

    public ListNode recurList(ListNode node){
        if(node == null)
            return node;
        
       
        
        if(node.child == null){
            while(node.child == null && node.next != null){
                ListNode tmp = new ListNode();
                tmp.val = node.val;     
                node.next = tmp;
                node = node.next;
            }
        } 
    
        ListNode child = recurList(node.child);

        
        
        return node;
    }
}
