class Solution {
    public int minOperations(int[][] grid, int x) {
        int len=grid.length*grid[0].length;
        int arr[]=new int[len];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                arr[i*grid[0].length+j]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int val=arr[len/2];
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if((arr[i]-val)%x!=0)
                return -1;
            count+=(Math.abs(arr[i]-val))/x;
        }
        return count;
    }
}