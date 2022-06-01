class Solution {
    class Pair
    {
        int row,col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair> queue=new LinkedList();
        int[][] height=new int[isWater.length][isWater[0].length];
        boolean vis[][]=new boolean[isWater.length][isWater[0].length];
        for(int i=0;i<isWater.length;i++)
        {
            for(int j=0;j<isWater[0].length;j++)
            {
                if(isWater[i][j]==1)
                {
                    queue.offer(new Pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        int[] distx=new int[]{1,0,-1,0};
        int[] disty=new int[]{0,1,0,-1};
        while(!queue.isEmpty())
        {
            Pair pair=queue.poll();
            for(int i=0;i<4;i++)
            {
                int row=pair.row+distx[i];
                int col=pair.col+disty[i];
                if(row<0||row==isWater.length||col<0||col==isWater[0].length||vis[row][col])
                    continue;
                height[row][col]=height[pair.row][pair.col]+1;
                queue.offer(new Pair(row,col));
                vis[row][col]=true;
            }
        }
        return height;
    }
}