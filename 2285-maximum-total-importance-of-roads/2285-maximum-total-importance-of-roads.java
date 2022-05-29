class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] count=new int[n];
        for(int[] road:roads)
        {
            count[road[0]]++;
            count[road[1]]++;
        }
        Arrays.sort(count);
        long imp=0;
        for(int i=0;i<n;i++)
        {
            imp+=count[i]*((long)i+1);
        }
        return imp;
    }
}