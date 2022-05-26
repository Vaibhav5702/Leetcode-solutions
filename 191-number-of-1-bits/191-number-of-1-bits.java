public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        String b=Integer.toBinaryString(n);
        for(int i=0;i<b.length();i++)
        {
            if(b.charAt(i)=='1')
                count++;
        }
        return count;
    }
}