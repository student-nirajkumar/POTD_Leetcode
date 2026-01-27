class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[256];
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;

        while (j < n) {
            arr[s.charAt(j)]++;

            while (arr[s.charAt(j)] > 1) {
                arr[s.charAt(i)]--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
