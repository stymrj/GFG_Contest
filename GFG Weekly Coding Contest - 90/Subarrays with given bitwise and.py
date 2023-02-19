class Solution:
 def totalSubarrays(self, n, x, arr):
     res = 0
     for i in range(n):
        ans = arr[i]
        if ans == x:
            res += 1
        for j in range(i+1,n):
            ans = ans & arr[j]
            if ans == x:
                res += 1
            if ans < x:
                break
     return res
