class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] soldier=new int[mat.length][2];
        for(int i=0;i<mat.length;i++)
        {
            int low=0,high=mat[0].length;
            while(low<high)
            {
                int mid=(low+high)/2;
                if(mat[i][mid]==1)
                    low=mid+1;
                else
                    high=mid;
            }
            soldier[i][0]=i;
            soldier[i][1]=high;
        }
        Arrays.sort(soldier,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=soldier[i][0];
        }
        return ans;
    }
}