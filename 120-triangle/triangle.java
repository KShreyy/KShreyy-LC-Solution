class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] t=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t[i][j]=-1;
            }
        }
        return helper(0,0,triangle,t);
        
    }
    public int helper(int i,int j,List<List<Integer>> triangle,int[][] t){
        int sum=Integer.MAX_VALUE;
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int down=helper(i+1,j,triangle,t);
        int right=helper(i+1,j+1,triangle,t);
        sum=triangle.get(i).get(j)+Math.min(down,right);
        return t[i][j]=sum;

    }
}