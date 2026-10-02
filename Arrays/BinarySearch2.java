public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int target = 8;
        int left = 0;
        int right = arr.length-1;
        if(arr[left]<arr[right]){
            int ansofacending = assendingarray(arr, target);
            System.out.println("Element found at indec : "+ ansofacending);
        }else{
            int ansofdecending =  decendingarray(arr, target);
            System.out.println("Element found att index : " + ansofdecending);
        }
        
    }   
    static int assendingarray(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
               right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    } 
    static int decendingarray(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
               left = mid + 1;
            }else if(arr[mid] < target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    } 
}


