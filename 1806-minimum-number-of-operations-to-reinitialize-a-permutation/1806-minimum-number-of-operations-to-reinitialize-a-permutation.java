class Solution {
    public int reinitializePermutation(int n) {
        int[] perm=new int[n];
        for(int i=0;i<n;i++)
        {
            perm[i]=i;
        }
        int count=0;
        do
        {
            int[] arr=new int[n];
            int i=0,j=n/2;
            for(int k=0;k<n;k+=2)
            {
                arr[k]=perm[i++];
                arr[k+1]=perm[j++];
            }
            count++;
            perm=arr;
        }while(perm[1]!=1);
        return count;
    }
}