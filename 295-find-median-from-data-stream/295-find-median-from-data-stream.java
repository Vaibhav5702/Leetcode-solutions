class MedianFinder {

    /** initialize your data structure here. */
    ArrayList<Integer> nums;
    public MedianFinder() {
        nums=new ArrayList();
    }
    
    public void addNum(int num) {
        int low=0,high=nums.size();
        while(low<high)
        {
            int mid=(low+high)/2;
            if(nums.get(mid)>=num)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        nums.add(high,num);
    }
    
    public double findMedian() {
        int n=nums.size();
        if(n%2==0)
        {
            return ((double)nums.get(n/2-1)+nums.get(n/2))/2;
        }
        else
        {
            return nums.get(n/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */