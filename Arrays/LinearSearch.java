public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 20, 7, 20, 15};
        int target = 20;
        boolean found = false;
        for(int i = 0; i<arr.length; i++){
            if(target == arr[i]){
                found = true;
                System.out.println("20 Found at index : " + i);
                break;
            }
        }
        if(!found){
            System.err.println("Not found");
        }

    }    
}
