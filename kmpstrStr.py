#TC : O(m+n)
#SC : O(n)
import numpy as np
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(needle == None or len(needle) == 0 or len(haystack)==0):
            return -1
        m = len(haystack)
        n = len(needle)
        i = 0
        j = 0
        lps = Solution.lps(self,needle)
        while(i < m):
            if(haystack[i] == needle[j]):
                i += 1
                j += 1
                if(j == n):
                    return (i - n)
            elif(haystack[i] != needle[j] and j > 0):
                j = lps[j - 1]
            elif(haystack[i] != needle[j] and j == 0):
                i += 1
        return -1



    def lps(self, needle):
        lps = [0] * len(needle)
        i = 1
        j = 0
        while(i < len(needle)):
            if(needle[i] == needle[j]):
                j+=1
                lps[i] = j
                i+=1
            elif(needle[i] != needle[j] and j > 0):
                j = lps[j-1]
            elif(needle[i] != needle[j] and j == 0):
                lps[i] = 0
                i +=1
        return lps
            
            




