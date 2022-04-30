class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList();
        getPaths(0,graph,new ArrayList<Integer>(),list);
        return list;
    }
    public void getPaths(int s,int[][] graph,List<Integer> path,List<List<Integer>> paths)
    {
        if(s==graph.length-1)
        {
            path.add(s);
            paths.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(s);
        for(int i:graph[s])
        {
            getPaths(i,graph,path,paths);
        }
        path.remove(path.size()-1);
    }
}