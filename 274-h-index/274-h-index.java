class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if(citations[0]>=citations.length)
            return citations.length;
        int low=1,high=citations.length-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int t=citations.length-mid;
            if(citations[t]>=mid)
            {
                if(citations[t-1]<=mid)
                    ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
}