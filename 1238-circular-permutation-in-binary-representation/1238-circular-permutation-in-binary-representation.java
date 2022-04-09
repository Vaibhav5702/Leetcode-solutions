class Solution {
    int size;
    boolean flag=false;
    public List<Integer> circularPermutation(int n, int start) {
        size=(int)Math.pow(2,n);
        boolean[] visited=new boolean[size];
        List<Integer> list=new ArrayList();
        visited[start]=true;
        list.add(start);
        generate(list,visited);
        return list;
    }
    public void generate(List<Integer> list,boolean[] visited)
    {
        if(list.size()==size)
        {
            flag=true;
            return;
        }
        for(int i=1;i<size;i*=2)
        {
            int val=list.get(list.size()-1)^i;
            if(!visited[val])
            {
                list.add(val);
                visited[val]=true;
                generate(list,visited);
                if(flag)
                    return;
                list.remove(list.size()-1);
                visited[val]=false;
            }
        }
    }
}