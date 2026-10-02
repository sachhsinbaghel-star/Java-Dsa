

public class FirstLastCount {
    public static void main(String[] args) {
        int[] arr = {7, 7, 2, 7, 9, 7, 1};
        int target = 7;
        int lastindex = -1;
        int count = 0;
        int first = -1;
        boolean found = false;
        for(int i = 0; i<arr.length; i++){
            if(target == arr[i]){
                count++;
            }
           if(target == arr[i] && first == -1){
                first = i;
                found = true;
}
            if(target == arr[i]){
                lastindex = i;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
        System.out.println("First occurrence " + first);
        System.out.println("Last occurrence " + lastindex);
        System.out.println("Total occurrences " + count);
    }
    
}
