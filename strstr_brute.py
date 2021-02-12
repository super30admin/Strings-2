# Time Complexity: O(m(m-n))
# Space Complexity: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(len(needle) == 0):
            return 0
        m = len(haystack)
        n = len(needle)
        i = 0
        while(i < m):
            if(needle[0] == haystack[i]):
                temp = i
                j = 0 # start of needle
                
                while(temp < m and needle[j] == haystack[temp]):
                    temp += 1
                    j += 1
                    if(j == n):
                        return i
            i += 1
                    
        return -1