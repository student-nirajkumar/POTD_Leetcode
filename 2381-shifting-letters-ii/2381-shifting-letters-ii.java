class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];

        for(int[]shift : shifts){
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if(dir == 1){
                diff[start]+=1;
                if(end+1 < n){
                    diff[end+1]-=1;
                }
            }
            else{
                diff[start]-=1;
                if(end+1 < n){
                    diff[end+1] += 1;
                }
            }
        }
        for(int i=1; i<n; i++){
            diff[i]+=diff[i-1];
        }
        StringBuilder res = new StringBuilder(s);
        for(int i=0; i<n; i++){
            int shift = diff[i] % 26;
            if(shift < 0){
                shift+=26;
            }
            char newChar = (char)(((res.charAt(i) - 'a' + shift) % 26) + 'a');
            res.setCharAt(i, newChar);
        }
               return res.toString();
    }
}