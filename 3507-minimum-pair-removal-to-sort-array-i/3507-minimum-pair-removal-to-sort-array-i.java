class Solution {
    public static int minPairSum(List<Integer> nums){
        int minSum = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<nums.size()-1; i++){
            int sum = nums.get(i) + nums.get(i+1);
            if(sum < minSum){
                minSum = sum;
                idx = i;
            }
        }
        return idx;
    }
    public static boolean isSorted(List<Integer> nums){
        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i) > nums.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        int op = 0;
        while(!isSorted(list)){
            int idx = minPairSum(list);
            int merged = list.get(idx) + list.get(idx+1);
            list.set(idx, merged);
            list.remove(idx+1);
            op++;
        }

        return op;
    }
}