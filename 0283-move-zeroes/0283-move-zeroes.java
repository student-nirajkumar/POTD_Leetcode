class Solution {
   public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while(j < n){
            if(arr[j] == 0){
                j++;
            }
            else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        
    }
}