class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,new Comparator<String>(){
            @Override
            public int compare(String a, String b)
            {
                if(a.length()!=b.length())
                    return b.length()-a.length();
                for(int i=0;i<a.length();i++)
                {
                    if(a.charAt(i)!=b.charAt(i))
                        return b.charAt(i)-a.charAt(i);
                }
                return 0;
            }
        });
        return nums[k-1];
    }
}