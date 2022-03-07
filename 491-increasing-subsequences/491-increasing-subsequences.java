class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        getSubseq(0,nums,list,new ArrayList());
        return list;
    }
    public void getSubseq(int index,int[] nums,List<List<Integer>> list,List<Integer> sub)
    {
        if(index==nums.length)
        {
            if(sub.size()>=2)
                list.add(new ArrayList(sub));
            return;
        }
        if(sub.isEmpty()||nums[index]>=sub.get(sub.size()-1))
        {
            sub.add(nums[index]);
            getSubseq(index+1,nums,list,sub);
            sub.remove(sub.size()-1);
        }
        if(sub.isEmpty()||!(nums[index]==sub.get(sub.size()-1)))
        {
            getSubseq(index+1,nums,list,sub);
        }
    }
}