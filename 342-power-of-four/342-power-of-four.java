class Solution {
    public boolean isPowerOfFour(int n) {
        return n>0&&(Math.log10(n)/Math.log10(4))%1==0;
    }
}