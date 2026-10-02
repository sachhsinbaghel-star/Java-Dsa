public class print{
    public static void main(String[] args) {
        int[] arr = {12,80,5,3,20};
        int big = arr[0];
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 20){
                arr[i] = 50;
            }
            if(big < arr[i]){
                big = arr[i];
            }
            System.out.println(arr[i] + " ");
        }
        System.out.println("MAx element si : " + big);
    }
}