class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] t=new int[m][n];
        return helper(m-1,n-1,obstacleGrid,t);
        
    }
    public int helper(int i,int j,int[][] obstacleGrid,int[][] t){
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        if(i==0 && j==0 ){
            return 1;        }
        if(i<0 || j<0){
            return 0; 
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        } 
        if(t[i][j]!=0){
            return t[i][j];
        }
        
        int sum=helper(i-1,j,obstacleGrid,t)+helper(i,j-1,obstacleGrid,t);
        
        return t[i][j]=sum;
    }
}
