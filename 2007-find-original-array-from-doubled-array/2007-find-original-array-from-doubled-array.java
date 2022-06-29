class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0)
            return new int[]{};
        int[] freq=new int[100001];
        Arrays.sort(changed);
        for(int num:changed)
        {
            freq[num]++;
        }
        int len=changed.length/2;
        int arr[]=new int[len];
        int j=0;
        for(int num:changed)
        {
            if(freq[num]==0)
                continue;
            if(num*2<100001&&freq[num*2]>0)
            {
                arr[j++]=num;
                freq[num]--;
                freq[num*2]--;
            }
            else
                return new int[]{};
        }
        return arr;
    }
}