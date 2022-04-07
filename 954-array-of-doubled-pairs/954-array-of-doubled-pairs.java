class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,neg=0;
        for(int a:arr)
        {
            if(a<0)
                neg++;
            min=Math.min(min,a);
            max=Math.max(max,a);
        }
        Arrays.sort(arr);
        if(neg!=0)
        {
            int freq[]=new int[-min+1];
            for(int i=neg-1;i>=0;i--)
            {
                int val=-arr[i];
                if(arr[i]%2==0&&freq[val/2]>0)
                    freq[val/2]--;
                else
                    freq[val]++;
            }
            for(int a:freq)
            {
                if(a>0)
                    return false;
            }
        }
        if(neg!=arr.length)
        {
            int freqMax[]=new int[max+1];
            for(int i=neg;i<arr.length;i++)
            {
                int val=arr[i];
                if(arr[i]%2==0&&freqMax[val/2]>0)
                    freqMax[val/2]--;
                else
                    freqMax[val]++;
            }
            for(int a:freqMax)
            {
                if(a>0)
                    return false;
            }
        }
        return true;
    }
    
}