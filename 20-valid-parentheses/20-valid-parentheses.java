class Solution {
    public boolean isValid(String s) {
        int top=-1;
        char a[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            char k=s.charAt(i);
            if(k=='('||k=='{'||k=='[')
            {
                a[++top]=k;
            }
            else
            {
                if(top!=-1&&(k==')'&& a[top]=='('||k=='}'&& a[top]=='{'||k==']'&& a[top]=='['))
                    top--;
                else
                    return false;
            }
        }
        if(top==-1)
            return true;
        else
            return false;
    }
}