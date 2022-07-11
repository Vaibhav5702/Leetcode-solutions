class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if(citations[0]>=citations.length)
            return citations.length;
        for(int i=citations.length-1;i>=1;i--)
        {
            int t=citations.length-i;
            if(citations[t]>=i&&citations[t-1]<=i)
                return i;
        }
        return 0;
    }
}