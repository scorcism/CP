from typing import List


def sayHello(name):
    print("Hello ", name)


def wordBreak(self, s: str, wordDict: List[str]) -> bool:

    dp = [False] * (len(s) + 1)
    dp[len(s)] = True

    for i in range(len(s) - 1, -1, -1):
        for w in wordDict:
            if (i+len(w)) <= len(s) and s[i:i+len(w)] == w:
                dp[i] = dp[i+len(w)]
                if dp[i]:
                    break
    return dp[0]

def numDecodings( s: str) -> int:
    dp = {len(s):1}
    
    def dfs(i):
        if i in dp:
            return dp[i]
        if s[i] == "0":
            return 0
        
        res = dfs(i+1)
        if(i+1<len(s) and (s[i] == "1" or s[i] == "2" and s[i+1] in "0123456")):
            dp[i] += res
        return res

    return dfs(0)


if __name__ == '__main__':
    # sayHello("Abhishek")
    # s = "catsandog"
    # wordDict = ["cats", "dog", "sand", "and", "cat"]
    # print(wordDict(s, wordDict))
    print(numDecodings("1234"))