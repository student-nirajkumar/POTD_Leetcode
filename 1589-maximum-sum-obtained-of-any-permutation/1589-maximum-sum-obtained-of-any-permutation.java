class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        int[] event = new int[n];
        for (int[] req : requests) {
            int start = req[0];
            int end = req[1];
            event[start] += 1;
            if (end + 1 < n) {
                event[end + 1] -= 1;
            }
        }
        for(int i=1; i<n; i++){
            event[i]+=event[i-1];
        }
        Arrays.sort(nums);
        Arrays.sort(event);
        
        long res = 0;
        for(int i=n-1; i>=0; i--){
            long contrib = (long) nums[i] * event[i];
            res = (res + contrib) % MOD;
        }

        return (int) res;
    }
}