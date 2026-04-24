class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int dash = 0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == 'L')
              left++;
            else if(ch == 'R')
               right++;
            else 
              dash++;
        }
        return Math.abs(left - right) + dash;
    }
}