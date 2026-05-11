class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            String s = nums[i] + "";

            for(int j = 0; j < s.length(); j++) {
                list.add(s.charAt(j) - '0');
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}