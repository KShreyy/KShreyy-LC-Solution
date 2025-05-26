class Solution {
    public int minInsertions(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] t=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
           for(int j=1;j<n+1;j++){
            if(s.charAt(i-1)==r.charAt(j-1)){
                t[i][j]=1+t[i-1][j-1];
            }
            else {
                t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
           } 
        }
        return n-t[n][n];
    }
}