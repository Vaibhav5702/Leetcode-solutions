class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod=new int[60];
        int count=0;
        for(int t:time)
        {
            int rem=(60-t%60);
            count+=mod[rem==60?0:rem];
            mod[t%60]++;
        }
        return count;
    }
}