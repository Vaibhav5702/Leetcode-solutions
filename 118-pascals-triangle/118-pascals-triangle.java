class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list=new ArrayList();
        List<Integer> list_in=new ArrayList();
        list_in.add(1);
        list.add(list_in);
        if(numRows==1)
            return list;
        list_in=new ArrayList();
        list_in.add(1);
        list_in.add(1);
        list.add(list_in);
        for(int i=2;i<numRows;i++)
        {
            list_in=new ArrayList();
            list_in.add(1);
            int x,y;
            for(int j=0;j<i-1;j++)
            {
                x=list.get(i-1).get(j);
                y=list.get(i-1).get(j+1);
                list_in.add(x+y);
            }
            list_in.add(1);
            list.add(list_in);
        }
        return list;
    }
}