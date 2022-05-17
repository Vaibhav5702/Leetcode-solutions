class Solution {
    public class Pair{
        int row,col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int n=grid.length;
        int[][] conn=new int[8][2];
        conn[0]=new int[]{-1,-1};
        conn[1]=new int[]{-1,0};
        conn[2]=new int[]{-1,1};
        conn[3]=new int[]{0,1};
        conn[4]=new int[]{1,1};
        conn[5]=new int[]{1,0};
        conn[6]=new int[]{1,-1};
        conn[7]=new int[]{0,-1};
        int[][] path=new int[n][n];
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                path[i][j]=100000;
            }
        }
        path[0][0]=1;
        Queue<Pair> queue=new LinkedList();
        queue.offer(new Pair(0,0));
        while(!queue.isEmpty())
        {
            Pair p=queue.poll();
            if(vis[p.row][p.col])
                continue;
            vis[p.row][p.col]=true;
            for(int[] con:conn)
            {
                int row=p.row+con[0];
                int col=p.col+con[1];
                if(row>=0&&row<n&&col>=0&&col<n&&grid[row][col]!=1)
                {
                    path[row][col]=Math.min(path[row][col],path[p.row][p.col]+1);
                    queue.offer(new Pair(row,col));
                }
            }
        }
        return path[n-1][n-1]==100000?-1:path[n-1][n-1];
    }
}