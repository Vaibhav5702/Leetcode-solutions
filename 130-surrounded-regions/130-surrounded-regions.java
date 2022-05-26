class Solution {
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        for(int i=0;i<n;i++)
        {
            dfs(0,i,board);
        }
        for(int i=0;i<n;i++)
        {
            dfs(m-1,i,board);
        }
        for(int i=0;i<m;i++)
        {
            dfs(i,0,board);
        }
        for(int i=0;i<m;i++)
        {
            dfs(i,n-1,board);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='*')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public void dfs(int i,int j,char[][] board)
    {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O')
            return;
        board[i][j]='*';
        dfs(i-1,j,board);
        dfs(i,j-1,board);
        dfs(i+1,j,board);
        dfs(i,j+1,board);
    }
}