class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+2];
        for(int i=0; i<bookings.length; i++){
            int start =bookings[i][0];
            int end = bookings[i][1];
            int count = bookings[i][2];

            diff[start]+=count;
            diff[end+1]-=count;

        }
        int[] res = new int[n];
        int currSum = 0;

        for(int i=1; i<=n; i++){
            currSum +=diff[i];
            res[i-1] = currSum ;
        }

        return res;

    }
}