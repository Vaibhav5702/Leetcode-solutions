class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<timePoints.size()-1;i++)
        {
            min=Math.min(min,getDiff(timePoints.get(i),timePoints.get(i+1)));
        }
        int a=getDiff("00:00",timePoints.get(0))+
            getDiff(timePoints.get(timePoints.size()-1),"23:60");
        return Math.min(min,a);
    }
    public int getDiff(String first,String second)
    {
        int h1=Integer.parseInt(first.substring(0,2));
        int m1=Integer.parseInt(first.substring(3));
        int h2=Integer.parseInt(second.substring(0,2));
        int m2=Integer.parseInt(second.substring(3));
        return h2*60+m2-h1*60-m1;
    }
}