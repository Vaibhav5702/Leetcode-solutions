class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] dirs={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=0;
                for(int[] dir: dirs)
                {
                    int x=i+dir[0];
                    int y=j+dir[1];
                    if(x>=0&&x<m&&y>=0&&y<n&&Math.abs(board[x][y])==1)
                        count++;
                }
                if(board[i][j]==0&&count==3)
                    board[i][j]=2;
                else if(board[i][j]==1&&(count<2||count>3))
                    board[i][j]=-1;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=board[i][j]>0?1:0;
            }
        }
    }
}