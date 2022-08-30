class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        colRotate(matrix);
    }
    public void transpose(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix.length;j++)
            {
                swap(matrix,i,j,j,i);
            }
        }
    }
    public void colRotate(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length/2;j++)
            {
                swap(matrix,i,j,i,matrix.length-1-j);
            }
        }
    }
    
    public void swap(int[][] matrix,int i1,int j1,int i2,int j2)
    {
        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;
    }
}