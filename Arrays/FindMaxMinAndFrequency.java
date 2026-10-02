

public class FindMaxMinAndFrequency {
    public static void main(String[] args) {
        int[] arr = {15, 7, 22, 3, 19, 22, 5}; 
        int max = arr[0];
        int min = arr[0];
        int frequency = 0;
        for(int i = 0; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){
                frequency++;
            }
        }
        System.out.println("Maximum : " + max);
        System.out.println("Minimum : " + min);
        System.out.println("Frequency of maximum : " + frequency);
    }    
}
