class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        StringBuilder sb=new StringBuilder();
        get(n,k,list,sb);
        return sb.toString();
    }
    public void get(int n,int k,List<Integer> list,StringBuilder sb)
    {
        if(n==0)
            return;
        for(int i=0;i<n;i++)
        {
            int f=fact(n-1);
            if(k>f)
            {
                k-=f;
            }
            else
            {
                sb.append(list.get(i));
                list.remove(i);
                get(n-1,k,list,sb);
                break;
            }
        }
    }
    public int fact(int n)
    {
        int pro=1;
        for(int i=2;i<=n;i++)
        {
            pro*=i;
        }
        return pro;
    }
}