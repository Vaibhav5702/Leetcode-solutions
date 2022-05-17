class Solution {
    public class Pair{
        int row,col,val;
        Pair(int row,int col,int val)
        {
            this.row=row;
            this.col=col;
            this.val=val;
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
        boolean[][] vis=new boolean[n][n];
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->(a.val-b.val));
        queue.offer(new Pair(0,0,1));
        while(!queue.isEmpty())
        {
            Pair p=queue.poll();
            if(vis[p.row][p.col])
                continue;
            if(p.row==n-1&&p.col==n-1)
                return p.val;
            vis[p.row][p.col]=true;
            for(int[] con:conn)
            {
                int row=p.row+con[0];
                int col=p.col+con[1];
                if(row>=0&&row<n&&col>=0&&col<n&&grid[row][col]!=1)
                {
                    queue.offer(new Pair(row,col,p.val+1));
                }
            }
        }
        return -1;
    }
}