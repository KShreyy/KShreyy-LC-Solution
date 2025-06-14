class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] t = new int[n][n];

        // Initialize the first row
        for (int j = 0; j < n; j++) {
            t[0][j] = matrix[0][j];
        }

        // Fill the DP table from row 1 to n-1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = t[i - 1][j];
                int left = (j > 0) ? t[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? t[i - 1][j + 1] : Integer.MAX_VALUE;

                t[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }

        // Find the minimum in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, t[n - 1][j]);
        }

        return minPathSum;
    }
}

/*class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int left=0; int right=0; int down=0;
        int sum=Integer.MAX_VALUE;
        int[][] t=new int[n][n];
        for(int i=0;i<n;i++){
            t[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
        if(i<n-1){        
             down=t[i][j]+t[i+1][j];}
        if(j>0 && i<n-1){
             left=t[i][j]+t[i+1][j-1];}
        if(j<n-1 && i<n-1){
             right=t[i][j]+t[i+1][j+1];}
        int mini=Math.min(left,right);
        t[i][j]=Math.min(down,mini);

            }
            
        }
        int maxi=t[n-1][0];
        for(int i=0;i<n;i++){
            maxi=Math.min(maxi,t[n-1][i]);
        }
        return maxi;}}
        
        /*
        if(i==n-1){return matrix[i][j]; }
        
        int left=helper(i+1,j-1,matrix,t);
        int down=helper(i+1,j,matrix,t);
        
        int right=helper(i+1,j+1,matrix,t);
        int mini=Math.min(left,right);
        sum=matrix[i][j]+Math.min(down,mini);
        
        return t[i][j]=sum;
    }
}
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int sum=Integer.MAX_VALUE;
        int[][] t=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t[i][j]=-1;
            }
        }
        for(int k=0;k<n;k++){
            sum=Math.min(sum,helper(0,k,matrix,t));
        }
        return sum;
    }
    public int helper(int i,int j,int[][] matrix,int[][] t){
        int sum=Integer.MAX_VALUE;
        int n=matrix.length;
        if(j<0 || j>=n){ return Integer.MAX_VALUE;}
        if(i==n-1){return matrix[i][j]; }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int left=helper(i+1,j-1,matrix,t);
        int down=helper(i+1,j,matrix,t);
        
        int right=helper(i+1,j+1,matrix,t);
        int mini=Math.min(left,right);
        sum=matrix[i][j]+Math.min(down,mini);
        
        return t[i][j]=sum;
    }
}
*/