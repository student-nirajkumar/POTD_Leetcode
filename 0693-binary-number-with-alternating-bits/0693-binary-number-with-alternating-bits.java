class Solution {
    public boolean hasAlternatingBits(int n) {
        int currbit = n%2;
         n= n/2;
        while(n > 0){
            if(currbit == n%2){
                return false;
            }
            currbit = n%2;
            n=n/2;
        }
        return true;
    }
}