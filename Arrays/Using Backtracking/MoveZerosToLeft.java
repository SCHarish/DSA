public class MoveZerosToLeft {
    public static void main(String args[]){
        int arr[] = {1, 10, 20, 0, 59, 63, 0, 88, 0};

        int i = arr.length - 1, j = arr.length - 1;

        while(i >= 0){
            if(arr[i] != 0){
                arr[j] = arr[i];
                j--;
            }
            i--;
        }

        while(j >= 0){
            arr[j] = 0;
            j--;
        }

        for(int a : arr){
            System.out.println(a);

        }

    }
}
