# Leetcode problem link : https://leetcode.com/problems/implement-strstr/
# Time Complexity:    O(m+n) where m is soze of needle and n is size of haystack
# Space Complexity:   O(n) for LPS
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        KMP algorithm focuses on finding repeated prefix and suffix and their index to avoid starting the match from index 0 everytime. Hence we create an LPS array of the index of prefix and suffix matching index for needle and accordingly traverse the haystack. 
'''  
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        if len(haystack) < len(needle):
            return -1
        LPS = self.calculateLPS(needle)
        i = 0
        j = 0
        
        while i < len(haystack):
            # case 1
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                # case 2
                if j == len(needle):
                    return i - j
            # case 3
            else:
                if j == 0:
                    i += 1
                else:
                    j = LPS[j-1]
        return -1
    
    def calculateLPS(self,needle):
        LPS = [0]*len(needle)
        
        j = 0
        i = 1
        
        while i < len(needle):
            # case 1
            if needle[i] == needle[j]:
                j += 1
                LPS[i] = j
                i += 1
            # case 2
            elif j > 0 and needle[i] != needle[j]:
                j = LPS[j-1]
            # case 3
            elif j == 0 and needle[i] != needle[j]:
                LPS[i] = 0
                i += 1
        return LPS