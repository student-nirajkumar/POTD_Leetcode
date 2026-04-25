

class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = getPos(points[i][0], points[i][1], side);
        }

        Arrays.sort(arr);

        int low = 0, high = 2 * side, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (can(arr, side, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean can(long[] arr, int side, int k, int d) {
        int n = arr.length;
        long perimeter = 4L * side;

        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = arr[i];
            ext[i + n] = arr[i] + perimeter;
        }

        int[] next = new int[2 * n];
        int j = 0;

        for (int i = 0; i < 2 * n; i++) {
            while (j < 2 * n && ext[j] - ext[i] < d) j++;
            next[i] = j;
        }

        for (int start = 0; start < n; start++) {
            int idx = start;
            int cnt = 1;

            while (cnt < k) {
                idx = next[idx];
                if (idx >= start + n) break;
                cnt++;
            }

            if (cnt == k) {
                long last = ext[idx];
                if (perimeter - (last - ext[start]) >= d) return true;
            }
        }

        return false;
    }

    long getPos(int x, int y, int side) {
        if (y == 0) return x;
        if (x == side) return side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }
}