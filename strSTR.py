"""
Time : O(M +N)
Space : O(N)
Leetcode : Yes
Explanation : KMP Algorithm
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #generate next array, need O(n) time
        i, j, m, n = -1, 0, len(haystack), len(needle)
        next = [-1] * n
        while j < n - 1:  
            #needle[k] stands for prefix, neelde[j] stands for postfix
            if i == -1 or needle[i] == needle[j]:   
                i, j = i + 1, j + 1
                next[j] = i
            else:
                i = next[i]
            
        #check through the haystack using next, need O(m) time
        i = j = 0
        while i < m and j < n:
            if j == -1 or haystack[i] == needle[j]:
                i, j = i + 1, j + 1
            else:
                j = next[j]
        if j == n:
            return i - j
        return -1
