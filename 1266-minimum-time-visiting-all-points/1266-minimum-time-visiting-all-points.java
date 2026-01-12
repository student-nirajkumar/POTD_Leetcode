class Solution {
    public int minTimeToVisitAllPoints(int[][] position) {
        int step = 0;
        int n = position.length;
        for (int i = 0; i < n - 1; i++) {
            int x1 = position[i][0];
            int y1 = position[i][1];

            int x2 = position[i + 1][0];
            int y2 = position[i + 1][1];
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            step += (Math.min(dx ,  dy) + Math.abs(dx - dy));

        }

        return step;
    }
}