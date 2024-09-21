#include <iostream>
#include <queue>

using namespace std;

class Solution
{
public:
    vector<int> max_of_subarrays(vector<int> &arr, int k) {
        int n = arr.size();
        vector<int> ans;

        deque<int> dq;
        int end = 0;

        for (end = 0; end < n; end++)
        {   
            if(!dq.empty() && arr[dq.front()] == end - k){
                dq.pop_front();
            }

            while(!dq.empty() && arr[dq.back()] < arr[end]){
                dq.pop_back();
            }

            dq.push_back(end);   

            if(end >= k - 1){
                ans.push_back(arr[dq.front()]);
            }
        }
        

        return ans;
    }
};

int main()
{
    Solution sol;
    vector<int> arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    int k = 3;

    vector<int> ans = sol.max_of_subarrays(arr,k);

    for (int n : ans)
    {
        cout << n << " ";
    }
}