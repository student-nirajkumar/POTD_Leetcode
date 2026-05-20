class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int A_i = 0; A_i <= i; A_i++) {
                for (int B_i = 0; B_i <= i; B_i++) {

                    if (A[A_i] == B[B_i]) {
                        count++;
                    }
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}