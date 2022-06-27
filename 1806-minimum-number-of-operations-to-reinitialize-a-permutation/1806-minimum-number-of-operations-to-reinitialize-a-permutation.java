class Solution {
    public int reinitializePermutation(int n) {
        int count=0;
        int x=1;
        while(count==0||x!=1)
        {
            if(x%2==0)
                x=x/2;
            else
                x=n/2+(x-1)/2;
            count++;
        }
        return count;
    }
}