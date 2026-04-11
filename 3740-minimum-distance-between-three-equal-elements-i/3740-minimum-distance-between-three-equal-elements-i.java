class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] != nums[j])
                    continue;

                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == nums[j]) {
                        ans = Math.min(ans, 2 * (k - i));
                        break;
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;

    }
}