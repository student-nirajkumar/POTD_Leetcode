class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int val = Integer.MIN_VALUE;
        while(i < j){
           int val1 = nums[i] + nums[j];
             val = Math.max(val, val1);
             i++;
             j--;
        }
        return val;
    }
}