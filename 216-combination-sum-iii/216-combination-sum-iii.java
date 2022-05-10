class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList();
        findCombinations(n,k,1,new ArrayList<Integer>(),result);
        return result;
    }
    public void findCombinations(int n,int k,int index,List<Integer> list,List<List<Integer>> result)
    {
        if(k==0&&n==0)
        {
            result.add(new ArrayList(list));
            return;
        }
        if(k==0||n<=0)
        {
            return;
        }
        for(int i=index;i<=9;i++)
        {
            list.add(i);
            findCombinations(n-i,k-1,i+1,list,result);
            list.remove(list.size()-1);
        }
    }
}