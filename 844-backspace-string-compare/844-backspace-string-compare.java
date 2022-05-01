class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch=='#')
                sb1.setLength(Math.max(sb1.length()-1,0));
            else
            sb1.append(ch);
        }
        for(char ch:t.toCharArray())
        {
            if(ch=='#')
                sb2.setLength(Math.max(sb2.length()-1,0));
            else
            sb2.append(ch);
        }
        return sb1.toString().equals(sb2.toString());
    }
}