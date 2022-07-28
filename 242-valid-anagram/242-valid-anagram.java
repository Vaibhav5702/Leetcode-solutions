class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t))
            return true;
        else if(s.length() != t.length())
            return  false;
        else{
            int[] arr = new int[26];
            for(char ch : s.toCharArray())
                arr[ch-'a']+=1;
            for(char ch : t.toCharArray())
                arr[ch-'a']-=1;
            for(int i=0;i<26;i++){
                if(arr[i]!=0)
                    return false;
            }
            return true;
        }
    }
}