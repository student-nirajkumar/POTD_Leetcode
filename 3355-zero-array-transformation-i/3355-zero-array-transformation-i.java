class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int x = 1;
            diff[start] += x;
            if (end + 1 < n) {
                diff[end + 1] -= x;
            }
        }
        int res[] = new int[n];
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += diff[i];
            res[i] = currSum;
        }
        for (int i = 0; i < n; i++) {
            if (res[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}