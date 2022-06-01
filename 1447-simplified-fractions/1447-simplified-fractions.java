class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if(hcf(i,j)==1)
                    list.add(i+"/"+j);
            }
        }
        return list;
    }
    public int hcf(int a,int b)
    {
        while(a%b!=0)
        {
            int c=a%b;
            a=b;
            b=c;
        }
        return b;
    }
}