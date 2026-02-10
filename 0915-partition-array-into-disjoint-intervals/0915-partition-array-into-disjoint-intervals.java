class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int currentMax = nums[0];
        int partitionIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax, nums[i]);

            if (nums[i] < leftMax) {
                partitionIndex = i;
                leftMax = currentMax;
            }
        }

        return partitionIndex + 1;
    }
}
