import java.util.Arrays;
public class Subarray {
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    int[] sums = subarray(arr);   // int nahi, int[]
    System.out.println("All sums: " + Arrays.toString(sums));
    int largest = sums[0];
    int Minimum = sums[0];
    for(int i = 0; i<= sums.length-1; i++){
        if(sums[i] > largest){
            largest = sums[i];
        }if(sums[i] < Minimum){
            Minimum = sums[i];
        }
        }
        System.out.println("Largest : " + largest);
        System.out.println("Largest : " + Minimum);
    }

    static int[] subarray(int[] arr){
        int n = arr.length;
        int[] sums = new int[n * (n + 1) / 2];
        int ptr = 0;
        for(int i = 0; i <arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k] +" -> "+ " ");
                    sum+=arr[k];
                    
                }
                sums[ptr] = sum;
                ptr++;
              
                System.out.println("This is the sum of first " + ptr + " subarray : " + sum);
               System.out.println();
            }
            
        }
         return sums;
    }    
}
