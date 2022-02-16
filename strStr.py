# Time complexity o(N)
# Space Complexity o(N)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        ptr1 = 0
        
        ptr2 = len(needle) - 1
        
        while(ptr2 < len(haystack)):
            if haystack[ptr1:ptr2+1] ==needle:
                return ptr1
            else:
                ptr1 +=1
                ptr2 +=1
        return -1
        