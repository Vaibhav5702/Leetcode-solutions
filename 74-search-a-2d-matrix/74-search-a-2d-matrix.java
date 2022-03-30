class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length-1;
        int index=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(matrix[mid][0]==target)
                return true;
            if(matrix[mid][0]<target)
            {
                index=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        low=0;
        high=matrix[0].length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(matrix[index][mid]==target)
                return true;
            else if(matrix[index][mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
    }
}