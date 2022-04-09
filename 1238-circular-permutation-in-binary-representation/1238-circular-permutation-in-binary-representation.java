class Solution {
    int size;
    boolean flag=false;
    public List<Integer> circularPermutation(int n, int start) {
        size=(int)Math.pow(2,n);
        boolean[] visited=new boolean[size];
        int ans[]=new int[size];
        visited[start]=true;
        ans[0]=start;
        generate(1,ans,visited);
        return IntStream.of(ans).boxed().collect(Collectors.toList());
    }
    public void generate(int index,int[] ans,boolean[] visited)
    {
        if(index==size)
        {
            flag=true;
            return;
        }
        for(int i=1;i<size;i*=2)
        {
            int val=ans[index-1]^i;
            if(!visited[val])
            {
                ans[index]=val;
                visited[val]=true;
                generate(index+1,ans,visited);
                if(flag)
                    return;
                ans[index]=0;
                visited[val]=false;
            }
        }
    }
}