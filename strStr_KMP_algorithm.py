# time - O(N)
# space - O(N) n is length of needle
#using KMp algorithm


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        
        LPS = self.LPS(needle)
       
        
        i = 0
        j = 0
        
        while i <len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                 
                
                
            if j == len(needle):
                return i-j
            
            elif j > 0 and i<len(haystack) and haystack[i] != needle[j]:
                j = LPS[j-1] 
            
            elif j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1
    
    def LPS(self, needle):
        i = 1
        j = 0
        lps = [None]*len(needle)
        
        lps[0] = 0
        
        while i<len(needle):
            
            if needle[j] == needle[i]:
                j += 1
                lps[i] = j
                i += 1
                
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j-1] 
            
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
        
        return lps      
