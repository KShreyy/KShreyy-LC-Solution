/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] t=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            t[0][i]=0;
        }
        for(int i=0;i<m+1;i++){
            t[i][0]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=i;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(i-1)){
                    t[i][j]=1+t[n-1][m-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
        
    }
}
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] t = new int[n + 1][m + 1];

        // No need to explicitly set t[0][*] and t[*][0] to 0 – already 0 by default

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[n][m];
    }
}
