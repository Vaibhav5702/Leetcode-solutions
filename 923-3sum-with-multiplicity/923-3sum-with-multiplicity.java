class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] count=new long[101];
        int keys=0;
        for(int a:arr)
        {
            count[a]++;
            if(count[a]==1)
                keys++;
        }
        int[] unique=new int[keys];
        int p=0;
        for(int i=0;i<=100;i++)
        {
            if(count[i]>0)
                unique[p++]=i;
        }
        long tot_ways=0;
        for(int i=0;i<keys;i++)
        {
            int x=unique[i];
            int rem=target-x;
            int low=i,high=keys-1;
            while(low<=high)
            {
                int y=unique[low],z=unique[high];
                int sum=y+z;
                if(sum<rem)
                    low++;
                else if(sum>rem)
                    high--;
                else
                {
                    if(i<low&&low<high)
                    {
                        tot_ways+=count[x]*count[y]*count[z];
                    }
                    else if(i==low&&low<high)
                    {
                        tot_ways+=count[x]*(count[x]-1)/2*count[z];
                    }
                    else if(i<low&&low==high)
                    {
                        tot_ways+=count[x]*count[y]*(count[y]-1)/2;
                    }
                    else
                    {
                        tot_ways+=count[x]*(count[x]-1)*(count[x]-2)/6;
                    }
                    tot_ways%=1000000007;
                    low++;
                    high--;
                }
            }
        }
        return (int) tot_ways;
    }
}