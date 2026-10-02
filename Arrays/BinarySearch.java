public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 10;
        int left = 0;
        int right = arr.length-1;
        boolean found = false;
        
        while(left<=right){
           int mid = (left+right)/2;
            if(arr[mid] == target){
                System.out.println("Found : "+ mid);
                found = true;
                break;
            }
           
           
            else if(target>arr[mid]){
                left = mid +1;
            }else{
                right = mid-1;
            }
         
        }
    if(!found){
        System.out.println("not found");
    
    }
    
}
}
