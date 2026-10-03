public class Binaryceiling {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8,9};
        int target = 7;
        int ans = ceilingarr(arr, target);
        System.out.println("Element is : " + ans);
        
    }
    static int ceilingarr(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target > arr[arr.length-1]){
                return -1;
            }else if(arr[mid] > target){
              right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                return arr[mid];
            }
        }return arr[left];
    }
    
}
