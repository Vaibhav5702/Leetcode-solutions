class Solution {
    public String simplifyPath(String path) {
        String[] arr=path.split("/");
        Deque<String> deque = new LinkedList<String>();
        for(String str:arr)
        {
            if(str.length()==0||str.equals("."))
                continue;
            if(str.equals(".."))
            {
                if(!deque.isEmpty())
                {
                    deque.pollLast();
                }
                continue;
            }
            deque.offerLast(str);
        }
        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty())
        {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.length()==0?"/":sb.toString();
    }
}