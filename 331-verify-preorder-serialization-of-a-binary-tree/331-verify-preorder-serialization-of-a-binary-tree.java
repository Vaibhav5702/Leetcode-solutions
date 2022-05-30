class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack=new Stack();
        String[] arr=preorder.split(",");
        for(int i=0;i<arr.length;i++)
        {
            stack.push(arr[i]);
            if(arr[i].equals("#"))
            {
                while(stack.size()>=3)
                {
                    stack.pop();
                    String b=stack.pop();
                    if(!b.equals("#"))
                    {
                        stack.push(b);
                        stack.push("#");
                        break;
                    }
                    else if(stack.pop().equals("#"))
                        return false;
                    else
                        stack.push("#");
                    
                    
                }
            }
        }
        return stack.size()==1&&stack.pop().equals("#");
    }
}