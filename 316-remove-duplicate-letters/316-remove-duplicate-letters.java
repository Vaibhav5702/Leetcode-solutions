class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack();
        int arr[]=new int[26];
        boolean visited[]=new boolean[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']--;
            if(visited[ch-'a'])
                continue;
            while(!stack.isEmpty()&&stack.peek()>ch&&arr[stack.peek()-'a']>0)
            {
                visited[stack.pop()-'a']=false;
            }
            visited[ch-'a']=true;
            stack.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}