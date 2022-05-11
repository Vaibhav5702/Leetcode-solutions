class Solution {
    public int countVowelStrings(int n) {
        
        int a=0,e=0,i=0,o=0,u=0;
        for(int j=1;j<=n;j++)
        {
            a=1;
            e=e+a;
            i=i+e;
            o=o+i;
            u=u+o;
        }
        return a+e+i+o+u;
    }
}