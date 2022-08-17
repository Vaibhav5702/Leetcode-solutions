class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String a[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new LinkedHashSet();
        for(String st:words)
        {
            StringBuilder morse=new StringBuilder();
            for(char ch:st.toCharArray())
            {
                morse.append(a[ch-'a']);
            }
            set.add(morse.toString());
        }
        return set.size();
    }
}