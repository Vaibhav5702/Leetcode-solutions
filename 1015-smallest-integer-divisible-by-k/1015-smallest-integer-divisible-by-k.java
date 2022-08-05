class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0)
            return -1;
        Set<Integer> set=new HashSet<>();
        int n=0;
        int count=0;
        while(true)
        {
            n=n%k*10+1;
            count++;
            if(n%k==0)
                return count;
            if(set.contains(n))
                return -1;
            set.add(n);
        }
    }
}