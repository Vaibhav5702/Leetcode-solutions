class Solution {
    public int numberOfSteps(int num) {
        if(num==1||num==0)
            return num; 
        else
            return 1+num%2+numberOfSteps(num/2);
    }
}