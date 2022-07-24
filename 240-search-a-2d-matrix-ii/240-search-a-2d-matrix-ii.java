class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        return checkTarget(matrix,0,n-1,target);
        
    }
    public boolean checkTarget(int[][] a,int m,int n,int target)
    {
        if(n<0)
            return false;
        int low=m,high=a.length;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(a[mid][n]==target)
                return true;
            else if(a[mid][n]>target)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return checkTarget(a,high,n-1,target);
    }
}