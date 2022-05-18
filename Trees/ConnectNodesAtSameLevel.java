public class ConnectNodesAtSameLevel {
    public static void main(String args[]){
        String str = ".Hari.sh";
        String splitResult[] = str.split("\\.", -1);
        System.out.println(splitResult[0]);
    }

    public static void connect(Node root){
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList();
        Node curr = null;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Node prev = curr;
                curr = queue.poll();
                
                if(i>0){
                    prev.next = curr;
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
             curr.next = null;
        }
     
        
        return root;
    }
}
