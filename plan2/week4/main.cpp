class Solution
{
public:
    int getMax(vector<int> &piles)
    {

        int maxNum = -1e6;

        for (int n : piles)
        {
            maxNum = max(n, maxNum);
        }

        return maxNum;
    }

    bool isValid(int h, int speed, vector<int> &piles)
    {
        int hours = 0;
        for (int i = 0; i < piles.size(); i++)
        {
            hours += (piles[i] + speed - 1) / speed;
        }
        return hours <= h;
    }

    int minEatingSpeed(vector<int> &piles, int h)
    {
        long long min = 1;
        long long max = getMax(piles);

        long long res = max;
        while (min <= max)
        {
            long long mid = min + (max - min) / 2;

            if (isValid(h, mid, piles))
            {
                res = mid;
                max = mid - 1;
            }
            else
            {
                min = mid + 1;
            }
        }

        return res;
    }
};