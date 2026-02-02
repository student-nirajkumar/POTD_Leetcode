class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int i=0; i<trips.length; i++){
            int passengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            diff[start]+=passengers;
            diff[end]-=passengers;
        }
        int curr = 0;
        for(int i = 0; i<1001; i++){
            curr+=diff[i];
            if(curr > capacity){
                return false;
            }
        }
        return true;
    }
}