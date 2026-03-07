class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){

            char c1 = (i % 2 == 0) ? '0' : '1';
            char c2 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != c1) diff1++;
            if(s.charAt(i) != c2) diff2++;

            if(i >= n){
                char pc1 = ((i-n) % 2 == 0) ? '0' : '1';
                char pc2 = ((i-n) % 2 == 0) ? '1' : '0';

                if(s.charAt(i-n) != pc1) diff1--;
                if(s.charAt(i-n) != pc2) diff2--;
            }

            if(i >= n-1){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}