import java.util.*;
import java.util.ArrayList;
public class AmazonPackageShipping {
   public static void main(String args[]){
        List<String> l1 = new ArrayList();
        l1.add("INSERT");
        l1.add("jasdlfjkj");

        List<String> l2 = new ArrayList();
        l2.add("INSERT");
        l2.add("adsfasdf");

        List<String> l3 = new ArrayList();
        l3.add("SHIP");
        l3.add("-");

        List<String> l4 = new ArrayList();
        l4.add("INSERT");
        l4.add("werwerdf");

        List<String> l5 = new ArrayList();
        l5.add("INSERT");
        l5.add("ioioioio");

        List<String> l6 = new ArrayList();
        l6.add("SHIP");
        l6.add("-");

        List<String> l7 = new ArrayList();
        l7.add("INSERT");
        l7.add("8989898");

        List<String> l8 = new ArrayList();
        l8.add("SHIP");
        l8.add("-");

        List<String> l9 = new ArrayList();
        l9.add("INSERT");
        l9.add("blsdflfer");

        List<String> l10 = new ArrayList();
        l10.add("SHIP");
        l10.add("-");

        List<List<String>> queries = new ArrayList(){
            {
                add(l1);
                add(l2);
                add(l3);
                add(l4);
                add(l5);
                add(l6);
                add(l7);
                add(l8);
                add(l9);
                add(l10);
            }
        };

        List<List<String>> result = new ArrayList();

        LinkedList<List<String>> queue = new LinkedList();

        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            String command = query.get(0);
            String packageId = query.get(1);


            if(command.equals("INSERT")){
                List<String> existingItems = queue.peek();
                if(queue.size() > 0){
                    if(existingItems.size() == 3){
                        queue.addLast(new ArrayList(){
                            {
                                add(packageId);
                            }
                        });

                    } else{
                        existingItems.add(packageId);
                        queue.removeFirst();
                        queue.addFirst(existingItems);
                    }
                } else{
                    queue.addLast(new ArrayList(){
                        {
                            add(packageId);
                        }
                    });
                }
            } else if(command.equals("SHIP")){
                if(queue.size() > 0){
                    List<String> existingItems = queue.peekFirst();
                    if(existingItems.size() < 3){
                        result.add(new ArrayList(){
                            {
                                add("N/A");
                            }
                        });
                    } else{
                        queue.removeFirst();
                        result.add(existingItems);
                    }
                } else{
                    result.add(new ArrayList(){
                        {
                            add("N/A");
                        }
                    });
                }
            }

        }

        
        for(int j=0;j<result.size();j++){
            System.out.println(result.get(j));
        }
   }
}
