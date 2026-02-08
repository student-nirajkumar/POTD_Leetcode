class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int nonZeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                nonZeroCount++;
            }
        }
        if (nonZeroCount == 0) {
            return 0;
        }
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            for (int j = l; j <= r; j++) {
                if (nums[j] > 0) {
                    int upadateValue = nums[j] - val;
                    if (upadateValue <= 0) {
                        upadateValue = 0;
                        nonZeroCount--;
                    }
                    nums[j] = upadateValue;
                }
            }
            if (nonZeroCount == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}