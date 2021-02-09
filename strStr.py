class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        '''
        Time Complexity: O(haystack-needle)needle
        Space Complexity: O(1)
        
        Missed a few edge cases and base condition with i<len(haystack) caused TLE.
        
        '''
        if(needle == ""):
            return 0
        if(len(haystack)<len(needle)):
            return -1
        i=0
        while(i<len(haystack)-len(needle)+1):
            if(haystack[i]==needle[0]):
                k = i
                j=0
                while(i<len(haystack) and j<len(needle) and haystack[i]==needle[j]):
                    i+=1
                    j+=1
                if(j==len(needle)):
                    return k
                
                i = k
            
            i+=1
        
        return -1
            
