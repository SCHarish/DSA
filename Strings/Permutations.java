import java.util.*;
public class Permutations {
    public static void main(String args[]){
        int nums[] = {1,2,3};
        permute(nums);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList(), nums);
        
        return result;
    }
    
    static void permute(List<List<Integer>> result, List<Integer> tmpList, int nums[]){
        
        if(tmpList.size() == nums.length){
            result.add(new ArrayList(tmpList));
        } else{
        
            for(int i=0; i< nums.length; i++){
                if(tmpList.contains(nums[i]))
                    continue;
                tmpList.add(nums[i]);
                permute(result, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}