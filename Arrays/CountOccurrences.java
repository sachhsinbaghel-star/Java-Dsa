public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr = {5, 20, 8, 20, 7, 20, 15};
    int target = 20;
    int count = 0;
    for(int i = 0; i<arr.length; i++){
        if(arr[i] == target){
            count++;
        }
        
    }
    System.out.println("20 occurs : " + count + " times");
    }    
}
