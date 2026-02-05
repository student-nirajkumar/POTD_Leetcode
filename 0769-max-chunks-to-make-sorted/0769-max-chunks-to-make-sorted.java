class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        suffix[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(arr[i], prefix[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(arr[i], suffix[i + 1]);
        }
        int pahleKaMax = 0;
        int badKaMin = 0;
        int chunk = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) {
                pahleKaMax = -1;
            } else {
                pahleKaMax =prefix[i - 1];
            }
            badKaMin = suffix[i];
            if (pahleKaMax < badKaMin) {
                chunk++;
            }
        }
        return chunk;
    }
}