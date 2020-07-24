# Time Complexity : Add - O(m+n), m is length of haystack, n - length of needle
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. use KMP algorithm
2. Maintain LPS array that store maximum length of prefix and suffix for the pattern
3. We have 2 pointers i, j. i moves across haystack and j moves across needle.
4. if j rosses the last element in needle, means the pattern exists
5. If not we relocate the j based on LPS
'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(needle) == 0:
            return 0
        i, j = 0, 0
        lps = self.calc_lps(needle)
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            
            if j == len(needle):
                return i-len(needle)
            
            if i<len(haystack) and j > 0 and haystack[i] != needle[j]:
                j = lps[j-1]
                
            elif i < len(haystack) and j==0 and haystack[i] != needle[j]:
                i += 1
        
        return -1
                
        
        
    def calc_lps(self, needle):
        
        lps = [0]*len(needle)
        j = 0
        i = 1
        
        while i < len(needle):
            
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
        
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j-1]
                
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
        return lps
                
                