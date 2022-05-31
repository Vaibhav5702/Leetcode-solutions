class Solution {
    public String addSpaces(String s, int[] spaces) {
        Arrays.sort(spaces);
        int j=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(i==spaces[j])
            {
                sb.append(" ");
                j++;
                if(j==spaces.length){
                    sb.append(s.substring(i));
                    break;
                }
                
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}