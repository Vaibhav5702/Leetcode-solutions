class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0||visited[i][j])
                    continue;
                int count=getCount(grid,i,j,visited);
                max=Math.max(max,count);
            }
        }
        return max;
    }
    public int getCount(int[][] grid,int i,int j, boolean[][] visited)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j])
            return 0;
        if(grid[i][j]==0)
            return 0;
        visited[i][j]=true;
        return 1+getCount(grid,i-1,j,visited)+getCount(grid,i,j-1,visited)
            +getCount(grid,i,j+1,visited)+getCount(grid,i+1,j,visited);
    }
}