class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='0'||visited[i][j])
                    continue;
                else
                {
                    count++;
                    formIsland(grid,visited,i,j);
                }
            }
        }
        return count;
    }
    public void formIsland(char[][] grid,boolean[][] visited,int i,int j)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'||visited[i][j])
            return;
        visited[i][j]=true;
        formIsland(grid,visited,i+1,j);
        formIsland(grid,visited,i-1,j);
        formIsland(grid,visited,i,j+1);
        formIsland(grid,visited,i,j-1);
    }
}