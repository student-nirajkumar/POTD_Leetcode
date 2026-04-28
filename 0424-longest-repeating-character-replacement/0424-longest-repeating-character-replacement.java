class Solution {
    public int characterReplacement(String s, int k) {
          int max = 0;
          int i=0, j=0;
          int maxC = 0;
          int[] counts = new int[26];
          
          while( j < s.length()){
                 char c = s.charAt(j);
                 counts[c - 'A']++;
                 maxC = Math.max(maxC, counts[c - 'A']);
                  
                  while((j - i + 1) - maxC > k){
                      char d = s.charAt(i);
                      counts[d-'A']--;
                      i++;
                      
                  }
                  
                  max = Math.max(max, j-i+1);
                  j++;
              
          }
          
          return max;
        
    }
}