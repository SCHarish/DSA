
class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hmap = new HashMap();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
      
        //construct the array with the mapped numbers
        
        int nums[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int mappedNo = hmap.get(s.charAt(i));
            nums[i] = mappedNo;
        }
        
        //In any scenario, if the smaller number appears in front of the 
        //larger no. for eg. Roman IV  array will be 1 5 we need to subtract the
        //i+1th no with i to get the actual no..
        int sum = 0; //initialize sum as zero
        
        for(int i=0;i<nums.length-1;i++){//Here nums.length-1 condition is because we are
//checking with the next no i.e i+1th index.. therefore last number need not to be checked
            if(nums[i] < nums[i+1]){ //checking if the next no. is greater
                sum  = sum - nums[i]; //if the next no. is greater subtract the current no.
            } else{
                sum = sum + nums[i]; //if the next no. is smaller than current then add the current no.
            }
        }
        
        //to add the last number
        sum = sum + nums[nums.length-1]; //last number not taken considered inside the for loop so adding it outside the loop
        
        return sum;
    }
}