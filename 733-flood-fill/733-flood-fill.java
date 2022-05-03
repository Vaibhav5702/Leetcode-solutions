class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int org=image[sr][sc];
        boolean[][] visited=new boolean[image.length][image[0].length];
        fillColor(image,sr,sc,newColor,org,visited);
        return image;
    }
    public void fillColor(int[][] image,int sr,int sc,int newColor,int org,boolean[][] vis)
    {
        if(sr<0||sr==image.length||sc<0||sc==image[0].length||image[sr][sc]!=org||vis[sr][sc])
            return;
        image[sr][sc]=newColor;
        vis[sr][sc]=true;
        fillColor(image,sr+1,sc,newColor,org,vis);
        fillColor(image,sr-1,sc,newColor,org,vis);
        fillColor(image,sr,sc+1,newColor,org,vis);
        fillColor(image,sr,sc-1,newColor,org,vis);
    }
}