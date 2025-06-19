import java.util.*;

class Solution {
    private void bfs(int node, List<List<Integer>> adjList, boolean[] vis) {
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int adjNode : adjList.get(current)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        // Initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[v];
        int count = 0;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                count++;
                bfs(i, adjList, vis);
            }
        }

        return count;
    }
}
