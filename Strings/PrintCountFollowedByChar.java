public class PrintCountFollowedByChar {
    public static void main(String args[]){
        String str = "aaaab";


        if(str.isEmpty() || str == null)
            return;


        StringBuilder result = new StringBuilder("");

        char curr_char = str.charAt(0);
        int count = 1;

        result.append(Character.toString(curr_char));

        for(int i=1; i<str.length();i++){
            if(curr_char != str.charAt(i)){
                result.append(count);
                curr_char = str.charAt(i);
                result.append(curr_char);
                count = 1;
            } else{
                count++;
            }
        }

        result.append(count);




        System.out.println(result.toString());
    }
}
