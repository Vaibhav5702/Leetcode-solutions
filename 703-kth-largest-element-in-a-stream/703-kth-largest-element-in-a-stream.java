class KthLargest {

    List<Integer> list;
    int k;
    boolean flag;
    public KthLargest(int k, int[] nums) {
        list=new ArrayList();
        flag=true;
        for(int num:nums)
        {
            add(num);
        }
        flag=false;
        this.k=k;
    }
    
    public int add(int val) {
        int low=0,high=list.size();
        while(low<high)
        {
            int mid=(low+high)/2;
            if(val<list.get(mid))
                low=mid+1;
            else
                high=mid;
        }
        list.add(high,val);
        return flag?0:list.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */