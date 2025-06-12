class Solution {
    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int[][] t=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                t[i][j]=-1;
            }
        }
        int s=Integer.MAX_VALUE;
        return helper(m-1,n-1,grid,t,s);
        
    }
    public int helper(int i,int j,int[][] grid,int[][] t,int s){
    
        
        if(i==0 && j==0 ){
            return grid[0][0];        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE; 
        }
        
         
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int left=helper(i-1,j,grid,t,s);
        int up=helper(i,j-1,grid,t,s);
        s=grid[i][j]+Math.min(left,up);
        
        return t[i][j]=s;
    }
}
