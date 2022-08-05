class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0)
            return -1;
        Set<Integer> set=new HashSet<>();
        int n=0;
        int temp=k;
        int count=0;
        while(temp!=0)
        {
            n=n*10+1;
            temp/=10;
            count++;
        }
        set.add(n);
        while(true)
        {
            if(n%k==0)
                return count;
            n=n%k*10+1;
            if(set.contains(n))
                return -1;
            set.add(n);
            count++;
        }
    }
}