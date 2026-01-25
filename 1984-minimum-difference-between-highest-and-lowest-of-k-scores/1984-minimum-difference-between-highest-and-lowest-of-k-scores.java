class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int i =0;
        int j = k-1;
        while(j < nums.length){
             int diff =  nums[j] - nums[i];
             minDiff = Math.min(diff, minDiff);
             i++;
             j++;
        }
        
   return minDiff;
    }
}