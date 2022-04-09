class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list=new ArrayList();
        int val;
        for(int i=1;i<=9;i++)
        {
            val=i;
            getNumbers(2,n,k,val,list);
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void getNumbers(int i, int n, int k,int val,List<Integer> list)
    {
        if(i>n)
        {
            list.add(val);
            return;
        }
        int prev=val%10;
        if(k!=0&&prev+k<=9)
        {
            val=val*10+(prev+k);
            getNumbers(i+1,n,k,val,list);
            val/=10;
        }
        if(prev-k>=0)
        {
            val=val*10+(prev-k);
            getNumbers(i+1,n,k,val,list);
            val/=10;
        }
    }
}