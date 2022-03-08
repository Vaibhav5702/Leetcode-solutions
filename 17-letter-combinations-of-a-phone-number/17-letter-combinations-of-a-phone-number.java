class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<String>();
        String[] st={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=combinations(st,digits);
        return res;
    }
    public List<String> combinations(String[] st,String digits)
    {
        if(digits.length()==0)
        {
            List<String> empty=new ArrayList();
            empty.add("");
            return empty;
        }
        char ch=digits.charAt(0);
        List<String> res=combinations(st,digits.substring(1));
        List<String> mres=new ArrayList();
        for(char c:st[ch-'0'].toCharArray())
        {
            for(String s:res)
            {
                mres.add(c+s);
            }
        }
        return mres;
    }
}