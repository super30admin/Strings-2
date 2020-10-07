class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #Time: O((N-M)M)
        #Space: O(1)
        
        if needle == "":
            return 0
        i = 0
        j = len(needle)-1
        
        #Check sliding window string of haystack equal to needle
        while j<len(haystack):
            curr = haystack[i:j+1]
            if curr==needle:
                return i
            i+=1
            j+=1
        return -1
                
                
