class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        ArrayList<Integer> ll = new ArrayList<>();
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int x = 0; x < nums.get(i); x++) {
                if ((x | (x + 1)) == nums.get(i)) {
                    ll.add(x);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ll.add(-1);
            }
        }

        int[] result = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            result[i] = ll.get(i);
        }

        return result;
    }
}
