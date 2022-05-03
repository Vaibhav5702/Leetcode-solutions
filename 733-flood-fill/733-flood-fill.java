class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor)
            return image;
        
        int color = image[sr][sc] ; 
        fill(image ,color, sr , sc , newColor);
        
        return image;
    }
    
    private void fill(int[][] image, int color , int sr, int sc, int newColor)
    {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
            return ;
        
        image[sr][sc] = newColor;
        
        fill(image ,color, sr+1 , sc , newColor);
        fill(image ,color, sr-1 , sc , newColor);
        fill(image , color,sr , sc+1 , newColor);
        fill(image , color,sr , sc-1, newColor);
        
    }
}