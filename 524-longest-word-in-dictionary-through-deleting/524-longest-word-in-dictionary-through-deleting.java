class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        String longest="";
        for(String word:dictionary)
        {
            if(word.length()>longest.length()&&check(word,s))
            {
                longest=word;
            }
        }
        return longest;
    }
    public boolean check(String word,String s)
    {
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(word.charAt(j)==s.charAt(i))
                j++;
            if(j==word.length())
                return true;
        }
        return false;
    }
}