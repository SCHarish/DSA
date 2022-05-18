// # Write a function that returns the indices of an array Arr for
// # elements that add up to a given number K
// # For example:
// # Given an array: [1,1,2,23,4,9,13,6,9] and K = 10, returns [[0,8],[1,5]


import java.util.*;
public class FindPairThatAddsToK {
  private static volatile int i = 0;
 public static void main(String []args){
    HashMap<Integer, Set<Integer>> reminderVsIndex = new HashMap<>();
    int[] arr = new int[] {1,1,2,23,4,9,13,6,9}; int k = 10;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.stream(arr).forEach(s->{
        if(reminderVsIndex.containsKey(s)) { //remainder kidachchu...apo index pair exist nu artham...
            Set<Integer> indices = reminderVsIndex.get(s);
            indices.stream().forEach(m -> {
                List<Integer> indexPairs = new ArrayList<>();
                indexPairs.add(m);
                indexPairs.add(i);
                result.add(indexPairs);
            });
        }
        else {
            int rem = k-s; //Given K minus array integer..gives the remainder required to form the pair..

            Set<Integer> ind = reminderVsIndex.getOrDefault(rem, new HashSet<>());
            ind.add(i);
        reminderVsIndex.put(rem, ind );
        }
        i++;
        
    });
    
    result.forEach(m->System.out.println(m.toString()));
    
 }


}
