class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double p1p2=Math.pow(p2[1]-p1[1],2)+Math.pow(p2[0]-p1[0],2);
        double p1p3=Math.pow(p3[1]-p1[1],2)+Math.pow(p3[0]-p1[0],2);
        double p1p4=Math.pow(p4[1]-p1[1],2)+Math.pow(p4[0]-p1[0],2);
        double p2p4=Math.pow(p4[1]-p2[1],2)+Math.pow(p4[0]-p2[0],2);
        double p3p4=Math.pow(p4[1]-p3[1],2)+Math.pow(p4[0]-p3[0],2);
        double p2p3=Math.pow(p3[1]-p2[1],2)+Math.pow(p3[0]-p2[0],2);
        if(p1p2==0||p1p3==0||p1p4==0)
            return false;
        if(p1p2==p1p3&&p1p4==2*p1p2)
        {
            
            if(p1p4==p2p3&&p1p2==p2p4&&p1p2==p3p4)
                return true;
        }
        if(p1p2==p1p4&&p1p3==2*p1p2)
        {
            if(p1p3==p2p4&&p1p2==p2p3&&p1p2==p3p4)
                return true;
        }
        if(p1p3==p1p4&&p1p2==2*p1p3)
        {
            if(p1p2==p3p4&&p1p3==p2p4&&p1p3==p2p3)
                return true;
        }
        return false;
    }
}