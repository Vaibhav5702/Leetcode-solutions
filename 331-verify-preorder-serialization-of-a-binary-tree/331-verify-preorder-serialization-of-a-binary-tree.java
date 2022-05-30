class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<Integer> stack=new Stack();
        String[] arr=preorder.split(",");
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals("#"))
            {
                stack.push(-1);
                while(stack.size()>=3)
                {
                    stack.pop();
                    int b=stack.pop();
                    if(b!=-1)
                    {
                        stack.push(b);
                        stack.push(-1);
                        break;
                    }
                    else if(stack.pop()==-1)
                        return false;
                    else
                        stack.push(-1);
                }
            }
            else
                stack.push(Integer.parseInt(arr[i]));
        }
        return stack.size()==1&&stack.pop()==-1;
    }
}