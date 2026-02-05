class Solution {
    public int maxChunksToSorted(int[] arr) {
        int cummSum = 0;
        int sum = 0;
        int n = arr.length;
        int chunk = 0;
        for(int i=0; i<n; i++){
             cummSum+=arr[i];
             sum += i;
             if(cummSum == sum){
                chunk++;
             }
        }
        return chunk;
    }
}