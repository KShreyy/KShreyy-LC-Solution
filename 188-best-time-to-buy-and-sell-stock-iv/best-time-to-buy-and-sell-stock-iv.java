
class Solution {
    public int maxProfit(int k,int[] prices) {
        int[][][] t=new int[prices.length+1][2][k+1];
        for(int i=0;i<=1;i++){
            for(int j=0;j<prices.length;j++){
                
                for(int z=0;z<=k;z++){
                    t[j][i][z]=-1;

                }
            }
        }
        
        return helper(0,1,prices,t,k);
    }
    public int helper(int ind,int buy,int[] prices,int[][][] t,int k){
        //base case
        
        int max_profit=0;
      
        if(ind==prices.length){
            return 0;
            
        }
        if(k==0){
            return 0;
        }
        if(t[ind][buy][k]!=-1){
            return t[ind][buy][k];
        }
        if(buy==1){
            max_profit=Math.max(-prices[ind]+helper(ind+1,0,prices,t,k),0+helper(ind+1,1,prices,t,k));
        }
        else{
            max_profit=Math.max(prices[ind]+helper(ind+1,1,prices,t,k-1),0+helper(ind+1,0,prices,t,k));
        }
        return t[ind][buy][k]=max_profit;
    }
}