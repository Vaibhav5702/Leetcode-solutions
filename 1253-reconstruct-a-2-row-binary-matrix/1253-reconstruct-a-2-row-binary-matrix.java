class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> list=new ArrayList();
        int sum=0,count2=0;
        for(int col:colsum)
        {
            if(col==2)
                count2++;
            sum+=col;
        }
        if(lower+upper!=sum||count2>lower||count2>upper)
            return list;
        int i=0;
        List<Integer> l=new ArrayList();
        List<Integer> u=new ArrayList();
        lower-=count2;
        upper-=count2;
        for(int col:colsum)
        {
            
            if(col==0)
            {
                l.add(0);
                u.add(0);
            }
            else if(col==2)
            {
                l.add(1);
                u.add(1);
            }
            else
            {
                if(upper>0)
                {
                    u.add(1);
                    l.add(0);
                    upper--;
                }
                else
                {
                    l.add(1);
                    u.add(0);
                    lower--;
                }
            }
        }
        list.add(u);
        list.add(l);
        return list;
    }
}