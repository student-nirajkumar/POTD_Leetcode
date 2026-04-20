class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        for (int i = 0; i < colors.length; i++) {
            int val = 0;
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;

    }
}