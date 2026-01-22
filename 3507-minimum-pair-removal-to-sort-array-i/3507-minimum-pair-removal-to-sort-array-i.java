class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;

        while (!isNonDecreasing(nums, n)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            nums[index] = nums[index] + nums[index + 1];
            for (int i = index + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            n--;
            operations++;
        }

        return operations;
    }
    private boolean isNonDecreasing(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
