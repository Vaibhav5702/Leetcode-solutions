class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral=new int[n][n];
        int num=1;
        int sr=0,sc=0,er=n-1,ec=n-1;
        while(true)
        {
            for(int i=sc;i<=ec;i++)
            {
                spiral[sr][i]=num++;
            }
            sr++;
            if(num>n*n)
                break;
            for(int i=sr;i<=er;i++)
            {
                spiral[i][ec]=num++;
            }
            if(num>n*n)
                break;
            ec--;
            for(int i=ec;i>=sc;i--)
            {
                spiral[er][i]=num++;
            }
            if(num>n*n)
                break;
            er--;
            for(int i=er;i>=sr;i--)
            {
                spiral[i][sc]=num++;
            }
            if(num>n*n)
                break;
            sc++;
        }
        return spiral;
    }
}