class Solution {
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long neg[][]=new long[m][n];
        long[][] pos=new long[m][n];
        neg[0][0]=grid[0][0]<0?grid[0][0]:1;
        pos[0][0]=grid[0][0]>=0?grid[0][0]:-1;
        boolean zero=false;
        if(grid[0][0]==0)
            zero=true;
        for(int i=1;i<m;i++)
        {
            if(grid[i][0]>=0)
            {
                pos[i][0]=pos[i-1][0]!=-1?pos[i-1][0]*grid[i][0]:-1;
                neg[i][0]=neg[i-1][0]!=1?neg[i-1][0]*grid[i][0]:1;
            }
            else
            {
                pos[i][0]=neg[i-1][0]!=1?neg[i-1][0]*grid[i][0]:-1;
                neg[i][0]=pos[i-1][0]!=-1?pos[i-1][0]*grid[i][0]:1;
            }
            zero|=grid[i][0]==0;
        }
        for(int i=1;i<n;i++)
        {
            if(grid[0][i]>=0)
            {
                pos[0][i]=pos[0][i-1]!=-1?pos[0][i-1]*grid[0][i]:-1;
                neg[0][i]=neg[0][i-1]!=1?neg[0][i-1]*grid[0][i]:1;
            }
            else
            {
                pos[0][i]=neg[0][i-1]!=1?neg[0][i-1]*grid[0][i]:-1;
                neg[0][i]=pos[0][i-1]!=-1?pos[0][i-1]*grid[0][i]:1;
            }
            zero|=grid[0][i]==0;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                long maxPos=Math.max(pos[i-1][j],pos[i][j-1]);
                long minNeg=Math.min(neg[i-1][j],neg[i][j-1]);
                if(grid[i][j]>=0)
                {
                    pos[i][j]=maxPos!=-1?maxPos*grid[i][j]:-1;
                    neg[i][j]=minNeg!=1?minNeg*grid[i][j]:1;
                }
                else
                {
                    pos[i][j]=minNeg!=1?minNeg*grid[i][j]:-1;
                    neg[i][j]=maxPos!=-1?maxPos*grid[i][j]:1;
                }
                zero|=grid[i][j]==0;
            }
        }
        if(pos[m-1][n-1]<0&&zero)
            return 0;
        return (int)(pos[m-1][n-1]%1000000007);
        
    }
}