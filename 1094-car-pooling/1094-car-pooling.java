class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> events = new TreeMap<>();
        for(int i=0; i<trips.length; i++){
            int passenger = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            events.put(start, events.getOrDefault(start, 0) + passenger);
            events.put(end, events.getOrDefault(end, 0) - passenger);
        }
        int currentPassengers = 0;
        for(int change : events.values()){
            currentPassengers +=change;
            if(currentPassengers > capacity){
                return false;
            }
        }
        return true;
    }
}