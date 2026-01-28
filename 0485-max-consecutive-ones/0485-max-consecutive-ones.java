class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int zero = 0;
        int maxLen = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zero++;
            }

           if (zero > 0) {   
                if (nums[i] == 0) {
                    zero--;
                }
                i++;             
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
