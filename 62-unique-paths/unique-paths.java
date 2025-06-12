class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t=new int[m][n];
        return helper(m-1,n-1,t);
        
    }
    public int helper(int i,int j,int[][] t){
        if(i==0 || j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(t[i][j]!=0){
            return t[i][j];
        }
        int sum=helper(i,j-1,t)+helper(i-1,j,t);
        
        return t[i][j]=sum;
    }
}