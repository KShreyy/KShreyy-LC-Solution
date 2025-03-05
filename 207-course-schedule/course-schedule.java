class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        //we now want to convert the given pair to adj list as after that we will convert it to indegree 
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());}    // this loop is to add arraylist inside an arraylist adj we defined earlier 
    //making of adjecncy list
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
               adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }    
    //now we want to make indegree hence intiate it first
        int indegree[]=new int[V]; 
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
                }
            }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();
    
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }


        if (topo.size() == V) return true;
        return false;

    }

}

