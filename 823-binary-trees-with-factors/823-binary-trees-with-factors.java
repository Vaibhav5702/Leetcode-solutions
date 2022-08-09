class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],i);
        }
        int[] dp=new int[arr.length];
        dp[0]=1;
        long ans=1;
        for(int i=1;i<arr.length;i++)
        {
            long sum=1;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i]%arr[j]==0&&map.containsKey(arr[i]/arr[j]))
                    sum+=(long)dp[map.get(arr[i]/arr[j])]*dp[map.get(arr[j])];
            }
            dp[i]=(int)(sum%1000000007);
            ans+=dp[i];
        }
        return (int)(ans%1000000007);
    }
}