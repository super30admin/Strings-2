class Solution:
    """
    
        Name : Shahreeen Shahjahan Psyche
        Time : O(M*N) [Size of the 2 strings]
        Space: O(1)
        
        Passed Test Case in LC : Yes
    
    
    """
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle:
            return 0
        
        start = 0
        end = 0
        
        while start < len(haystack) - len(needle) + 1:
            if haystack[start] == needle[0]:
                end = start
                count = 0
                for i in range(len(needle)):
                    if needle[i] == haystack[end]:
                        count += 1
                        end += 1
                    else:
                        break
                if count == len(needle):
                    return start
            start += 1
        return -1
          
