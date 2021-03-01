# // Time Complexity : 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# KMP algorithm
# find the prefix and suffix array match of the needle and store in array of lps
# go through haystack to check if the chars are matching 
# if first char matches : increase both the pointers
# does not match move j to lps[j-1]
# if j is at 0 increse p

class Solution:
    lps = []
    def strStr(self, haystack: str, needle: str) -> int:
        # if len(haystack)==0: return 0
        if len(needle)==0: return 0
        h = len(haystack)
        n = len(needle)
        self.lps = [0]*n
        self.lpsf(needle)

        p, j = 0, 0
        
        while p<h:
            if haystack[p] == needle[j]:
                j+=1
                p+=1
                if j == n:
                    return p-n  
            elif j>0 and haystack[p] != needle[j]:
                j = self.lps[j-1]
            elif j==0 and haystack[p] != needle[j]:
                p+=1
        return -1
                
        
        
    def lpsf(self,needle):
        n = len(needle)
        i,j = 1,0
        
        while i<n:
            if needle[i] == needle[j]:
                j+=1
                self.lps[i] = j
                i+=1
            elif j>0 and self.lps[i] != needle[j]:
                j = self.lps[j-1]
            elif j==0 and self.lps[i] != needle[j]:
                self.lps[i]=0
                i+=1
                
                