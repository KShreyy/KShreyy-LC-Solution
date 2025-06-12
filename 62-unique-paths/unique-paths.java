class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t=new int[m][n];
        for(int i=0;i<n;i++){
            t[0][i]=1;
        }
        for(int i=0;i<m;i++){
            t[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                
                t[i][j]=t[i-1][j]+t[i][j-1];}
            }
        
        return t[m-1][n-1];
    }}
/*class Solution {
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
}*/