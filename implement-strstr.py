# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if m < n:
            return -1
        i = 0
        j = 0
        lps = self.lps(needle)
        print(lps)

        while (i < m):
            if needle[j] == haystack[i]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            elif j > 0:
                j = lps[j-1]
            else:
                i += 1
        return -1
    
    def lps(self, needle):
        j = 0
        i = 1
        n = len(needle)
        lps = [0] * n
        
        while i < n:
            if needle[j] == needle[i]:
                j += 1
                lps[i] = j
                i += 1
            elif j > 0:
                j = lps[j-1]
            else:
                lps[i] = 0
                i += 1
        return lps