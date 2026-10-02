public class BinarySearchPractice {
    public static void main(String[] args){
        int[] arr = {3, 8, 12, 17, 25, 31, 40, 56, 72};
        int target = 31;
        int left = 0;
        int right = arr.length-1;
        boolean found = false;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                System.out.println("Found at index : "+ mid);
                found = true;
                break;
            }        
            else if(target>arr[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
    
}
