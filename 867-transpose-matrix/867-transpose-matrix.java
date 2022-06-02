class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        
        int[][] matrixClone = new int[matrix[0].length][matrix.length];
        
        for (int yIndex = 0; yIndex < matrix.length; yIndex++) {
            for (int xIndex = 0; xIndex < matrix[0].length; xIndex++) {
                matrixClone[xIndex][yIndex] = matrix[yIndex][xIndex];
            }
        }
        return matrixClone;
    }
}