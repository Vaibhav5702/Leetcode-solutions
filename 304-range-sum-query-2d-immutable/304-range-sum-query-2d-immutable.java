class NumMatrix {

    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        preSum=new int[matrix.length][matrix[0].length];
        int sum=0;
        for(int i=0;i<matrix[0].length;i++)
        {
            sum+=matrix[0][i];
            preSum[0][i]=sum;
        }
        for(int i=1;i<matrix.length;i++)
        {
            sum=0;
            for(int j=0;j<matrix[0].length;j++)
            {
                sum+=matrix[i][j];
                preSum[i][j]=sum+preSum[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1!=0&&col1!=0)
            return preSum[row2][col2]+preSum[row1-1][col1-1]-preSum[row1-1][col2]-preSum[row2][col1-1];
        else if(col1!=0)
            return preSum[row2][col2]-preSum[row2][col1-1];
        else if(row1!=0)
            return preSum[row2][col2]-preSum[row1-1][col2];
        else
            return preSum[row2][col2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */