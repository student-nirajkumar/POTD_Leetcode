class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int n = arr.length;
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < mindiff) {
                mindiff = diff;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == mindiff) {
                List<Integer> res1 = new ArrayList<>(); 
                res1.add(arr[i]);
                res1.add(arr[i + 1]);
                res.add(res1);
            }
        }

        return res;
    }
}
