class Solution {
    public int[][] diagonalSort(int[][] mat) {
        List<List<Integer>> list=new ArrayList();
        int m=mat.length;
        int n=mat[0].length;
        if(m==1||n==1)
            return mat;
        for(int i=0;i<m+n-1;i++)
        {
            list.add(new ArrayList());
        }
        for(int i=0;i<m;i++)
        {
            for(int j=n-1;j>=0;j--)
            {
                list.get(i-j+n-1).add(mat[i][j]);
            }
        }
        for(int i=0;i<list.size();i++)
        {
            Collections.sort(list.get(i));
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j]=list.get(i-j+n-1).get(0);
                list.get(i-j+n-1).remove(0);
            }
        }
        return mat;
    }
}