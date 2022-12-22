
class Solution
{


    public:
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        set<pair<int,int>> st;
        vector<int> dust(V,1e9);

        st.insert({0,S});
        dist[S] = 0;

        while(!st.empty()){
            auto it = *{st.begin()}
            int node = it.second;
            int dis = it.first;
            st.erase(it);

            for(auto it: adj[node]){
                int adjNode = it[0];
                int edgW = it[1];

                if(dis + edjW < dist[adjNode]){

                    // rease if it existed
                    if(dist[adjNode] != 1e9){
                        st.erase({dist[adjNode], adjNode});
                    }

                    dist[adjNode] = dist + edjW;
                    st.insert({dist[adjNode],adjNode});
                }
            }

        } 
    return dist;
    }

}
