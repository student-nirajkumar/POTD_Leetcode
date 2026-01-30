class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] year = new int[2051];
        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0];
            int death = logs[i][1];

            year[birth] += 1;
            year[death] -= 1;
        }
        int maxPopulation = 0;
        int currentPopulation = 0;
        int answerYear = 1950;

        for (int y = 1950; y <= 2050; y++) {
            currentPopulation += year[y];

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answerYear = y;
            }
        }

        return answerYear;
    }
}
