import java.util.*;
public class SubSetsWithoutDuplicate{
    public static void main(String args[]){
        int nums[] =  { 1, 2, 2 };
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        subSetRecur(result, 0, new ArrayList(), nums);
     
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static void subSetRecur(List<List<Integer>> result, int start, List<Integer> temp, int nums[]){
   
        result.add(new ArrayList(temp));
    

        for(int i = start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);  
            subSetRecur(result, i+1, temp, nums);
            temp.remove(temp.size()-1);
        }
    }
}