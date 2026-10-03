public class Binaryfloor {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8,10};
        int target = 9;
        int ans = Florarr(arr, target);
        System.out.println("Element is : " + ans);
        
    }
    static int Florarr(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target > arr[arr.length-1]){
                return -1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }

        }
        return arr[right];
    }
    
    
}
