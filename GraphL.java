import java.util.*;
import java.util.LinkedList;

class GraphL {

    public static void MatrixR() {
        int n = 4;
        int m = 6;
        int adj[][] = new int[n + 1][m + 1];

        // edge 1 -- 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2 -- 3
        adj[2][3] = 1;
        adj[3][2] = 1;

        // edge 3 -- 4
        adj[3][4] = 1;
        adj[4][3] = 1;

        /*
         * adj[u][v] = 1;
         * adj[v][u] = 1;
         */

    }

    public static void ListR() {
        int n = 3;
        int m = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());

            // edge 1 -- 2
            adj.get(1).add(2);
            adj.get(2).add(1);

            // edge 2 -- 3
            adj.get(2).add(3);
            adj.get(3).add(2);

            // edge 3 -- 4
            adj.get(3).add(4);
            adj.get(4).add(3);

            /*
             * adj.get(u).add(v);
             * adj.get(v).add(u);
             */
        }

        // Print
        for (int i = 1; i < n; i++) {
            for (int j = 0; i < adj.get(1).size(); j++) {
                System.out.println(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();

        boolean vis[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if (vis[node] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        // Boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V + 1];
        vis[0] = true;

        ArrayList<Integer> ls = new ArrayList<>();
        dfs(V, vis, adj, ls);

        return ls;
    }

    // adj matrix to adj list
    private static void change(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }

    private static void dfsnP(int i, int[] vis, ArrayList<ArrayList<Integer>> adjList) {
        // DFS call
        vis[i] = 1;

        for (Integer it : adjList.get(i)) {
            if (vis[it] == 0) {
                dfsnP(it, vis, adjList);
            }
        }

    }

    private static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here

        // Converting adj matrix to adj list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).get(i);
                }
            }
        }
        // to store the total count
        int count = 0;
        // to store the visited index values
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfsnP(i, vis, adjList);
            }
        }

        return count;
    }

    public static int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;

        // checking each and every cell in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // check if the current value is 1 and it is not visited
                if (vis[row][col] == 0 && vis[row][col] == '1') {
                    count++;
                    bfsNI(row, col, vis, grid);
                }
            }
        }

        return count;
    }

    private static void bfsNI(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        Queue<Pairs> q = new LinkedList<Pairs>();
        q.add(new Pairs(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            // Traverse in the neighbour and mark the if it is land
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = ro + delrow;
                    int ncol = co + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pairs(nrow, ncol));
                    }
                }
            }
        }
    }

    static class Pairs {
        // To store row and col index
        int first;
        int second;

        Pairs(int row, int col) {
            this.first = first;
            this.second = second;
        }
    }

    /*
     * T.C -> O(N[Total nodes]xM[total directions])
     * S.C -> O(NxM) + O(NxM)
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int initialColor = image[sr][sc];

        dfsFF(image, sr, sc, newColor, ans, initialColor);
        return ans;
    }

    private void dfsFF(int[][] image, int row, int col, int newColor, int[][] ans, int initialColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        // The deltarows and deltacols will be the combinations the following
        int[] deltarow = { -1, 0, +1, 0 };
        int[] deltacol = { 0, +1, 0, -1 };

        // Checking for all the four side, with respect to that current element
        // Loop till 4 coz there are exactly 4 neighbour
        for (int i = 0; i < 4; i++) {
            // Getting the neighbour row and neighbour column
            int nrow = row + deltarow[i];
            int ncol = col + deltacol[i];

            // Testing the edge cases
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                    image[nrow][ncol] == initialColor && image[nrow][ncol] != newColor) {
                dfsFF(image, nrow, ncol, newColor, ans, initialColor);
            }
        }
    }

    static class Store {
        int row;
        int col;
        int time;

        Store(int _row, int _col, int _time) {
            this.row = _row;
            this.col = _col;
            this.time = _time;
        }
    }

    /*
     * T.C -> O(NxM)
     * S.C -> O(NxM)
     */
    public static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // to store the visited row and column values
        int[][] vis = new int[n][m];

        // to store all the fresh oranges
        int freshOraneg = 0;

        // creating a PQ for BFS traversal
        Queue<Store> q = new LinkedList<Store>();

        // Storing all the rotton oranges an if not then marking ti with 0 and also
        // counting all the fresh orange
        // i = row
        // j = col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Store(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                // count all the fresh oranges for cross validating
                if (grid[i][j] == 1)
                    freshOraneg = freshOraneg + 1;
            }
        }
        // To store the final max time
        int time = 0;

        // neighbour co-ordinates
        int[] deltarow = { -1, 0, 1, 0 };
        int[] deltacol = { 0, 1, 0, -1 };

        // performing the BFS
        int countInTraverse = 0;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int tm = q.peek().time;
            // remove the element after
            q.remove();
            // Getting the max time
            time = Math.max(time, tm);

            // with respect to the neighbour checking the condiiton
            for (int i = 0; i < 4; i++) {
                // checking for all teh neighbour
                int nrow = row + deltarow[i];
                int ncol = col + deltacol[i];

                // checking for the conditions
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m
                        && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.add(new Store(nrow, ncol, tm + 1));
                    vis[nrow][ncol] = 2;
                    countInTraverse += 1;
                }
            }
        }

        if (countInTraverse != freshOraneg)
            return -1;

        return time;
    }

    static class CyclePair {
        int parent;
        int currentNode;

        CyclePair(int _p, int _c) {
            this.parent = _p;
            this.currentNode = _c;
        }
    }

    public static boolean detect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        // make it visited
        vis[i] = true;
        // creaet a queue for the bfs
        Queue<CyclePair> q = new LinkedList<CyclePair>();

        // add source and -1 to the parent
        q.add(new CyclePair(src, -1));

        // perform the bfs
        while (!q.isEmpty) {
            // get the parent and the curren node
            int p = q.peek().parent;
            int c = q.peek().currentNode;

            q.remove();

            for (int adjNode : adj.get(c)) {
                // if the adjecent node is not visited mark that as visited
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    // and put it into the queue
                    q.add(adjNode, p);
                } else if (p != adjNode) {
                    // if the adjnode is already vistied
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // for visited array
        boolean[] vis = new boolean[V];

        // for provinces
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                // if the current node is not visited visit it
                if (detect(i, adj, vis))
                    return true;
            }
        }
        return false;
    }

    class nPair {
        int x, y, steps;

        nPair(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.steps = s;
        }
    }

    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        // Visited array
        int[][] vis = new int[n][m];
        // To store the distance
        int[][] dist = new int[n][m];

        Queue<nPair> q = new LinkedList<>();

        // Iterating through the grid to store all the 1's in the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // store store the co-ordinate and step to the queue
                    q.add(new nPair(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        // Iterating in the queue
        while (!q.isEmpty()) {
            // get all the values related with the node
            int x = q.peek().x;
            int y = q.peek().y;
            int steps = q.peek().steps;
            q.poll();

            // store the steps in the distance array matrix
            dist[x][y] = steps;

            // Lokking at top bottom left and right
            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                // getting the neighbour rows and columns
                int nrow = x + delrow[i];
                int ncol = y + delcol[i];

                // checking the edge cases
                if (nrow >= 0 && ncol >= 0 && ncol < n && nrow < n && ncol < m && vis[nrow][ncol] == 0) {
                    q.add(new nPair(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }

    public static void dfsFill(int i, int j, int[][] vis, char[][] a){
        vis[i][j] = 1;

        int n = a.length;
        int m = a[0].length;
        // check for top, bottom, left, right
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,+1,0,-1};

        for(int k =0; k< 4; k++){
            int nrow = i + delrow[k];
            int ncol = i+delcol[k];
         
            if(nrow >= 0 && ncol >= 0 &&  nrow < m && nrow < m && ncol < n 
            && vis[nrow][ncol] ==0 && a[nrow][ncol] == 'O'
            ){
                dfs(nrow,ncol,vis,a);
            }

        }
    }

    static char[][] fill(int n, int m, char a[][]) {
        // code here

        int[][] vis = new int[n][m];

        // Traverse 1st row and last row
        for (int i = 0; i < m; i++) {

            if (vis[0][i] == 0 && a[0][i] == 'O') {
                dfsFill(0, i, vis, a);
            }

            if (vis[n - 1][i] == 0 && a[n - 1][i] == 'O') {
                dfsFill(n - 1, i, vis, a);
            }
        }
        // Traversing the 1st column and last column
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && a[i][0] == 'O') {
                dfsFill(i, 0, vis, a);
            }

            if (vis[i][m - 1] == 0 && a[i][m - 1] == 'O') {
                dfsFill(i, m - 1, vis, a);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }

        return a;
    }

    public static class NOC {
        int row;
        int col;

        NOC(int n, int m){
            this.row = n;
            this.col = m;
        }
    }

    public static int numberOfEnclaves(int[][] grid) 
    {
        int n = grid.length; 
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        Queue<NOC> q = new LinkedList<>();
        
        // putl all the edges having 1 in the queue
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m ;j++){
                if(grid[i][j] == 1){
                    q.add(new NOC(i,j));
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            // check for all the  4 direction
            int[] delrow = {-1,0,1,0};
            int[] delcol = {0,+1,0,-1};

            for(int i = 0; i< 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow <n && ncol <m &&
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1
                ){
                    q.add(new NOC(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int count= 0;
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m ;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    count++;
                }
            }
        }

    return count;
    }

        public static void dfsISland(int row, int col, int[][] vis, ArrayList<String> vec, int[][] grid, int row0,
                int col0) {
            vis[row][col] = 1;
            vec.add(toString(row - row0, col - col0));
            int n = grid.length;
            int m = grid[0].length;

            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, -1, 0, 1 };

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    dfsISland(nrow, ncol, vis, vec, grid, row0, col0);
                }
            }
        }

        private static String toString(int r, int c) {
            return Integer.toString(r) + " " + Integer.toString(c);
        }

    public int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        // to store all the answer and to avoid duplicates
        HashSet<ArrayList<String>> st = new HashSet<>();
        // Iterating through the grid
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(vis[i][j] == 0 && grid [i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfsISland(i,j,vis,vec,grid,i,j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }

        public static boolean checkBFS(int i, ArrayList<ArrayList<Integer>> adj, int[] colors) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 0;

            while (!q.isEmpty()) {
                int front = q.peek();
                q.remove();

                for (int it : adj.get(front)) {
                    // if the current node is not colors color it with the opposite color of parent
                    if (colors[it] == -1) {
                        colors[it] = 1 - colors[front];
                        q.add(it);

                        // if the current node is alreay colord and it is as same the parent color then
                        // return false
                    } else if (colors[it] == colors[front]) {
                        return false;
                    }

                }
            }
            return true;
        }

        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            int colors[] = new int[V];
            Arrays.fill(colors, -1);

            // for connected components
            for (int i = 0; i < V; i++) {
                // check if the node is not being touch
                if (colors[i] == -1) {
                    if (checkBFS(i, V, adj, colors) == false) {
                        return false;
                    }
                }
            }
            return true;
        }

        private static void dfsTopo(int node, int[] vis, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj) {
            vis[node] = 1;
            for (int it : adj.get(node)) {
                if (vis[it] == 0) {
                    dfsTopo(it, vis, s, adj);
                }
            }
            s.push(node);
        }

        public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
            // add your code here
            int[] vis = new int[V];
            int[] ans = new int[V];

            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    dfsTopo(i, vis, s, adj);
                }
            }

            int i = 0;
            while (!s.isEmpty()) {
                ans[i++] = s.peek();
                s.pop();
            }

            return ans;
        }

        public static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
            // add your code here
            // 1st getting all the indegree of the nodes and storint it into array
            int[] indegree = new int[V];
            // iterting through the adj list
            for (int i = 0; i < V; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            // putting all the nodes having 0 indegree into the queue
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            // to store answer
            int[] topo = new int[V];
            int i = 0;
            while (!q.isEmpty()) {
                int node = q.peek();
                q.poll();

                topo[i++] = node;

                for (int it : adj.get(node)) {
                    // Take that node and as the inderepe is taken out decrease the indegress of
                    // that node.
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }

            return topo;
        }

        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // Performing kahns algorithm
            int[] indegree = new int[V];
            for (int i = 0; i < V; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            int cnt;
            int i = 0;

            while (!q.isEmpty()) {
                int front = q.peek();
                q.remove();
                cnt++;

                for (int it : q.get(front)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
                if (cnt == V) {
                    // Here all the elements are added topo sort means the topo sort is well
                    // performaed which means the provided graph is an DAG
                    return false;
                }

                return true;
            }
        }

        // Prerequisite Tasks
        public boolean isPossible(int N, int[][] prerequisites) {
            // Your Code goes here
            // Creating a adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }

            int m = prerequisites.length;

            for (int i = 0; i < m; i++) {
                // map the 1st 0th index element with the 2nd element
                adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            // Perform the kahns algo - topo sort bfs
            // store the in depress
            int[] indegree = new int[N];
            for (int i = 0; i < N; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            // Performing the BFS
            Queue<Integer> q = new LinkedList<>();
            // put all the element having 0 in depree in the queue
            for (int i = 0; i < N; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            // to store all the topo elements
            int[] topo = new int[N];
            int i = 0;
            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                topo[i++] = node;
                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            // if all the elemts are aaded to the topo array means the given graph is
            // acyclic gaph so tere is not cycle between the elements
            if (topo.length == N) {
                return true;
            }
            return false;
        }

        // course schedule
    public boolean findOrder(int N,int m, ArrayList<ArrayList<Integer>> adj  prerequisites)
    {
        // Your Code goes here
        // Creating a adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< N; i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;

        for(int i = 0; i< m; i++){
            // map the 1st 0th index element with the 2nd element
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        // Perform the kahns algo - topo sort bfs
        // store the in depress
        int[] indegree = new int [N];
        for(int i  = 0; i < N; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        // Performing the BFS
        Queue<Integer> q = new LinkedList<>();
        // put all the element having 0 in depree in the queue
        for(int i = 0; i< N ;i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }

        // to store all the topo elements
        int[] topo = new int[N];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        // if all the elemts are aaded to the topo array means the given graph is acyclic gaph so tere is not cycle between the elements
        if(topo.length == N){
            return topo;
        }
        int[] arr = {};
        return arr;
    }

        // Eventual Safe States
        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

            // To store all the safe nodes
            List<Integer> safe = new ArrayList<>();

            // To store the indegree of the nodes
            int[] indegree = new int[V];

            // Reverse the adjancy list
            // To store the reverse
            List<List<Integer>> adjRev = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjRev.add(new ArrayList<>());
            }

            for (int i = 0; i < V; i++) {
                for (int it : adj.get(i)) {
                    // i -> it
                    // it -> i
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int node = q.peek();
                q.remove();

                safe.add(node);

                for (int it : adjRev.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }

            Collections.sort(safe);
            return safe;

        }

        public static List<Integer> fsTopo(int V, List<List<Integer>> adj) {
            int[] indegree = new int[V];

            for (int i = 0; i < V; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> topo = new ArrayList<>();

            int i = 0;
            while (!q.isEmpty()) {
                int node = q.peek();
                q.poll();

                topo.add(node);

                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            return topo;
        }

        public String findOrder(String[] dict, int N, int K) {
            // Write your code here
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                adj.add(new ArrayList<>());
            }

            // Iterate through the dictionary
            for (int i = 0; i < N - 1; i++) {
                String s1 = dict[i];
                String s2 = dict[i + 1];

                int len = Math.min(s1.length(), s2.length());

                for (int ptr = 0; ptr < len; ptr++) {
                    if (s1.charAt(ptr) != s2.charAt(ptr)) {
                        adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                        break;
                    }
                }
            }
            List<Integer> topo = fsTopo(K, adj);
            String ans = "";

            for (int it : topo) {
                ans = ans + (char) (it + (int) ('a'));
            }

            return ans;
        }

        static class SPPairs {
            int first;
            int second;

            SPPairs(int a, int b) {
                this.first = a;
                this.second = b;
            }
        }

        private void sptopo(int i, ArrayList<ArrayList<SPPairs>> adj, int[] vis, Stack<Integer> st) {
            vis[i] = 1;

            for (int it = 0; it < adj.get(i).size(); it++) {
                int v = adj.get(i).get(it).first;
                if (vis[v] == 0) {
                    sptopo(v, adj, vis, st);
                }
            }

            st.add(i);
        }

        // Shortest path in Directed Acyclic Grap
        public int[] shortestPath(int N, int M, int[][] edges) {

            ArrayList<ArrayList<SPPairs>> adj = new ArrayList<>();

            // Create a adj list with the gien data
            for (int i = 0; i < N; i++) {
                ArrayList<SPPairs> tmp = new ArrayList<SPPairs>();
                adj.add(tmp);
            }

            // add data to the adj list
            for (int i = 0; i < M; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                adj.get(u).add(new SPPairs(v, wt));

            }
            // perform the topo sort
            int[] vis = new int[N];

            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < N; i++) {
                if (vis[i] == 0) {
                    sptopo(i, adj, vis, st);
                }
            }

            // step 2
            int dis[] = new int[N];
            Arrays.fill(dis, (int) 1e9);

            dis[0] = 0;

            while (!st.isEmpty()) {
                int node = st.peek();
                st.pop();

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).first;
                    int wt = adj.get(node).get(i).second;

                    if (dis[node] + wt < dis[v]) {
                        dis[v] = wt + dis[node];
                    }
                }
            }

            return dis;
        }

        // Word Ladder I

        static class Ladderpair {
            String first;
            int second;

            Ladderpair(String a, int b) {
                this.first = a;
                this.second = b;
            }
        }

        public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
            // Queue to store the words and their level
            Queue<Ladderpair> q = new LinkedList<>();

            q.add(new Ladderpair(startWord, 1));

            // set to store the wordlist
            Set<String> st = new HashSet<>();

            int len = wordList.length;
            for (int i = 0; i < len; i++) {
                st.add(wordList[i]);
            }

            st.remove(startWord);

            while (!q.isEmpty()) {
                String word = q.peek().first;
                int steps = q.peek().second;

                q.remove();

                if (word.equals(targetWord) == true) {
                    return steps;
                }

                // Loop through each char of that word
                for (int i = 0; i < word.length(); i++) {
                    // replace each index position with all the 26 char
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // convert the string into char array so that each alphabet can be replaced.
                        char[] charArray = word.toCharArray();
                        charArray[i] = ch;
                        // convert back toe char array to string
                        String wordBack = new String(charArray);

                        // check if the new word is present into the set and if present add it to queue
                        // and remove it from the set

                        if (st.contains(wordBack) == true) {
                            st.remove(wordBack);
                            q.add(new Ladderpair(wordBack, steps + 1));
                        }

                    }
                }

            }

            return 0;

        }

        // Word Ladder II

        public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {

        }
    

    // Dijkstra algorithm using PQ

    // To store distance and node
    static class PairdPQ{
        int dis;
        int node;

        PairdPQ(int a, int b){
            this.dis  = a;
            this.node = b;
        }
    }

    static int[] dijkstraPQ(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Declaring a PQ
        // Min-heap
        PriorityQueue<PairdPQ> pq = new PriorityQueue<PairdPQ>((x,y)->x.dis - y.dis);

        int[] dist = new int[V]; // To store the distances
        for(int i = 0; i< V ; i++) dist[i] = (int)(1e9);

        dist[0] = 0;
        pq.add(new PairdPQ(0, S));

        while(!pq.isEmpty()){
            int distance = pq.peek().dis;
            int node = pq.peek().node;

            pq.remove();

            // Iterate in the adj list
            for(int i = 0; i< adj.get(node).size(); i++){
                // Getting the adjacent node and adj weight
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // if the new edge weigth + distance(node weight) is less then the previous one update the old one of that node
                // distance => Till reacheing the parent node position we have taken this much distance
                if(distance + edgeWeight < dist[adjNode]){
                    // we got a better distance
                    dist[adjNode] = distance + edgeWeight;

                    pq.add(new PairdPQ(dist[adjNode], adjNode));
                }

            }

        }

        return dist;
    }

        public static void main(String[] args) {

        }
    
}