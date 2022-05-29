class Solution {
    class Cell{
        int x;
        int y;
        int rem;
        Cell(int x,int y,int rem)
        {
            this.x=x;
            this.y=y;
            this.rem=rem;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] min=new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                min[i][j]=100001;
            }
        }
        min[0][0]=0;
        PriorityQueue<Cell> pq=new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell a,Cell b)
            {
                return a.rem-b.rem;
            }
        });
        pq.offer(new Cell(0,0,min[0][0]));
        int[] x=new int[]{-1,0,1,0};
        int[] y=new int[]{0,-1,0,1};
        while(!pq.isEmpty())
        {
            Cell cell=pq.poll();
            for(int i=0;i<4;i++)
            {
                int row=cell.x+x[i];
                int col=cell.y+y[i];
                if(row>=0&&row<m&&col>=0&&col<n)
                {
                    if(min[row][col]>min[cell.x][cell.y]+grid[row][col])
                    {
                        if(min[row][col]!=100001)
                        {
                            Cell prev=new Cell(row,col,min[row][col]);
                            pq.remove(prev);
                        }
                        min[row][col]=min[cell.x][cell.y]+grid[row][col];
                        pq.offer(new Cell(row,col,min[row][col]));
                    }
                }
            }
        }
        return min[m-1][n-1];
    }
}