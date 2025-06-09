class Solution {
    public int maxProfit(int[] prices) {
        int[][][] t=new int[prices.length+1][2][3];
        for(int i=0;i<=1;i++){
            for(int j=0;j<prices.length;j++){
                
                for(int k=0;k<=2;k++){
                    t[j][i][k]=-1;

                }
            }
        }
        int cap=2;
        return helper(0,1,prices,t,cap);
    }
    public int helper(int ind,int buy,int[] prices,int[][][] t,int cap){
        //base case
        
        int max_profit=0;
      
        if(ind==prices.length){
            return 0;
            
        }
        if(cap==0){
            return 0;
        }
        if(t[ind][buy][cap]!=-1){
            return t[ind][buy][cap];
        }
        if(buy==1){
            max_profit=Math.max(-prices[ind]+helper(ind+1,0,prices,t,cap),0+helper(ind+1,1,prices,t,cap));
        }
        else{
            max_profit=Math.max(prices[ind]+helper(ind+1,1,prices,t,cap-1),0+helper(ind+1,0,prices,t,cap));
        }
        return t[ind][buy][cap]=max_profit;
    }
}