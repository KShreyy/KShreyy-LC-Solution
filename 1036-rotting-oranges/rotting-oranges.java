/*import java.util.*;
public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int freshcount=0;
        for(int i=0<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][]j==2){
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1){
                    freshcount=freshcount+1
                }
            }
        }
        while(!q.isEmpty(){
            int curr[]=q.poll();
            int r=curr[0]; int c=curr[1]; int t=curr[2];
            if()
        }*/

public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize the queue and fresh count
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});  // {row, col, time}
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int maxTime = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            maxTime = Math.max(maxTime, t);

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // rot it
                    freshCount--;
                    queue.add(new int[]{nr, nc, t + 1});
                }
            }
        }

        return freshCount == 0 ? maxTime : -1;
    }
}
