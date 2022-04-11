class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        k=k%(m*n);
        List<List<Integer>> list=new ArrayList();
        int t=k;
        int shift=m*n-k;
        for(int i=0;i<m;i++)
        {
            list.add(new ArrayList());
        }
        int p=m*n;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(shift==p)
                {
                    p=shift;
                    shift=0;
                    
                }
                list.get(i).add(grid[shift/n][shift%n]);
                shift++;
            }
        }
        return list;
    }
}