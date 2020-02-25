"""
Time Complexity : O(m+n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        
        if not needle or n == 0:
            return 0
        
        i = 0
        j = 0
        lps = self.lps(needle, n)
        
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            
            if j == n:
                return i - j
            
            elif i < m and haystack[i] != needle[j]:
                if j > 0:
                    j = lps[j-1]
                elif j == 0:
                    i += 1
        
        return -1
    
    # builds lps array (largest prefix-suffix)
    def lps(self, pattern, n):
        i = 1
        j = 0
        lps_arr = [0]*n
        
        while i < n:
            if pattern[i] == pattern[j]:
                j += 1
                lps_arr[i] = j
                i += 1
                
            elif pattern[i] != pattern[j]:
                if j > 0:
                    j = lps_arr[j-1]
                elif j == 0:
                    lps_arr[i] = 0
                    i += 1
        return lps_arr
            