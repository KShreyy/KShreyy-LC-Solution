/*
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<Integer,Integer> q=new ArrayList<>();
        q.add(sr,sc);
        while(!q.isEmpty()){
            int i=q.poll();
            if(i+1>n-1 && j){
                image[i+1][j]
            }
            
        }    }
}*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image; // Already the same color, no need to process
        dfs(image, sr, sc, oldColor, color);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        
        // Check boundaries and color match
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != oldColor) {
            return;
        }
        
        image[r][c] = newColor; // Fill the pixel
        
        // Explore the 4 directions
        dfs(image, r + 1, c, oldColor, newColor); // down
        dfs(image, r - 1, c, oldColor, newColor); // up
        dfs(image, r, c + 1, oldColor, newColor); // right
        dfs(image, r, c - 1, oldColor, newColor); // left
    }
}
