class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            res <<= 1;          // shift result left
            res |= (n & 1);     // add last bit of n
            n >>>= 1;           // unsigned shift n right
        }

        return res;
    }
}
