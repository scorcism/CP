
def dp(arr, total, i , mem):
    key = str(total) + ':' + str(i)
    if key in mem:
        return mem[key]
    if total == 0:
        return 1
    if total < 0:
        return 0
    if i < 0:
        return 0
    if total < arr[i]:
        to_return = dp(arr, total, i-1, mem)
    else:
        to_return = (dp(arr, total - arr[i], i-1, mem) + dp(arr, total, i-1, mem))
    mem[key] = to_return
    return to_return
    
def count_set(arr,total):
    mem = {} # empty dict or hash table
    return dp(arr, total , len(arr) - 1, mem)

def solve(arr, total, i ):
    if total == 0:
        return 1
    if total < 0:
        return 0
    if i < 0:
        return 0
    if total < arr[i]:
        to_return = solve(arr, total, i-1)
    else:
        to_return = (solve(arr, total - arr[i], i-1) + solve(arr, total, i-1))
    return to_return
    
def count(arr,total):
    return solve(arr, total , len(arr) - 1)

if __name__ == "__main__":
    arr = [1,2,3,4,5,6,10]
    total = 12
    print(count(arr, total))
