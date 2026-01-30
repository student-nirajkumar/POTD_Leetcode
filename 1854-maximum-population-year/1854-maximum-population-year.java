class Solution {
    public int maximumPopulation(int[][] logs) {

        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            events.add(new int[]{logs[i][0], 1});   
            events.add(new int[]{logs[i][1], -1});  
        }
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; 
            }
            return a[0] - b[0];
        });

        int curr = 0;
        int maxPop = 0;
        int result = 0;
        for (int i = 0; i < events.size(); i++) {
            curr += events.get(i)[1];

            if (curr > maxPop) {
                maxPop = curr;
                result = events.get(i)[0];
            }
        }

        return result;
    }
}
