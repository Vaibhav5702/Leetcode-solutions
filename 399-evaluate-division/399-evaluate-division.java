class Solution {
    HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
    public class Pair{
        String v;
        double w;
        Pair(String v, double w){
            this.v = v;
            this.w = w;
        }
        public String toString(){
            return v + " " + w;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0;i<equations.size();i++)
        {
            String a1=equations.get(i).get(0);
            String a2=equations.get(i).get(1);
            if(!graph.containsKey(a1))
            {
                ArrayList<Pair> list=new ArrayList();
                graph.put(a1,list); 
            }
            graph.get(a1).add(new Pair(a2,values[i]));
            if(!graph.containsKey(a2))
            {
                ArrayList<Pair> list=new ArrayList();
                graph.put(a2,list); 
            }
            graph.get(a2).add(new Pair(a1,1/values[i]));
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            List<String> query=queries.get(i);
            if(!graph.containsKey(query.get(0))||!graph.containsKey(query.get(1)))
            {
                ans[i]=-1;
                continue;
            }
            Set<String> set=new HashSet();
            ans[i]=dfs(query.get(0),set,query.get(1));
        }
        return ans;
    }
    public double dfs(String num,Set<String> set,String den)
    {
        set.add(num);
        if(num.equals(den))
            return 1;
        for(Pair edge:graph.get(num))
        {
            if(!set.contains(edge.v))
            {
                double ret=dfs(edge.v,set,den);
                if(ret>0)
                    return edge.w*ret;
            }
        }
        return -1.0;
    }
}