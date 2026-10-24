public class MaxSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,-3,4,-5,6,7,8,9};
        maxx(arr);
    }
    static void maxx(int[] arr) {
        int start = 0;
        int end = 0;
        double max = Double.NEGATIVE_INFINITY;
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum+=arr[k];
                    
                }
                if(max < sum){
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }System.out.println("Maximum : " + max);
        System.out.println("Max Subarray : ");
        for(int k = start; k <= end; k++){
            System.out.print(arr[k] + " ");
        }
        
    }
    
}
