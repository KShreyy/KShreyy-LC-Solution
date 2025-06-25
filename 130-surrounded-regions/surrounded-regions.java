class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        // 1. Enqueue all border 'O's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') q.offer(new int[]{i, 0});
            if (board[i][n-1] == 'O') q.offer(new int[]{i, n-1});
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') q.offer(new int[]{0, j});
            if (board[m-1][j] == 'O') q.offer(new int[]{m-1, j});
        }

        // directions
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        // 2. BFS from border 'O's
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (board[r][c] != 'O') continue;
            board[r][c] = 'E'; // mark as escape

            for (int[] d : dir) {
                int rr = r + d[0], cc = c + d[1];
                if (rr >= 0 && rr < m && cc >= 0 && cc < n && board[rr][cc] == 'O') {
                    q.offer(new int[]{rr, cc});
                }
            }
        }

        // 3. Flip remaining 'O'->'X' and 'E'->'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }
}

/*class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=1;i<=n-2;i++){
            for(int j=1;j<=m-2;j++){
                if(board[i][j]=="O"){
                  q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(r-1>0){
                if(board[r-1][c]=="O"){
                    board[r-1][c]="X";
                }
            }
            if(c-1>0){
                if(board[r][c-1]=="O"){
                    board[r][c-1]="X";
                }
            }
            if(r+1<n-1){
                if(board[r+1][c]=="O"){
                    board[r+1][c]="X";
                }
            }
            if(c+1<n-1){
                if(board[r][c-1]=="O"){
                    board[r][c-1]="X";
                }
            }
            }
        }
}     
*/                                   