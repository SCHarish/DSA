public class ConnectNodesAtSameLevel {
    public static void main(String args[]){
        String str = ".Hari.sh";
        String splitResult[] = str.split("\\.", -1);
        System.out.println(splitResult[0]);
    }
}
