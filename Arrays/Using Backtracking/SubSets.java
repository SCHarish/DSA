import java.util.*;
public class SubSets{


    static void getSubSets(int nums[], int start, List<List<Integer>> result, List<Integer> tmpList){
        result.add(new ArrayList(tmpList));
        for(int i = start;i<nums.length;i++){
            tmpList.add(nums[i]);
            getSubSets(nums, i+1, result, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }
    public static void main(String args[]){
        int nums[] ={1,2,3};
        //start is 0
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList();
        getSubSets(nums, 0, result, tmpList);
    }
}