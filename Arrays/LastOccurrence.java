

public class LastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 20, 8, 20, 7, 20, 20};
        int target = 20;
        int lastindex= -1;
        for(int i = 0; i<arr.length; i++){
            if(target == arr[i]){
                lastindex = i;
            }
        }
        System.out.println("Last occurrence of 20 is at index : " + lastindex);
    }
}
