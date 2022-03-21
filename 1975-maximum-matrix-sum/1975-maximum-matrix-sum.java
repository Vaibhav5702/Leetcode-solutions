class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long num_negative=0,num_zero=0,sum=0,min=Integer.MAX_VALUE;
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    num_zero++;
                if(matrix[i][j]<0)
                    num_negative++;
                sum+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(num_zero>0||num_negative%2==0)
            return sum;
        return sum-2*min;
    }
}