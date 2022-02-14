class Solution:
    
    # Sliding Window --> Brute Force
    # TC: O(m-n)*n --> m = len(haystack), n = len(needle)
    # SC: O(1)
    
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        m = len(haystack)
        
        if n > m:
            return -1
        
        if haystack == "":
            return 0
        
        p1 = 0
        p2 = n - 1
        
        while p2 < m:
            if haystack[p1: p2+1] == needle:
                return p1
            
            p1 += 1
            p2 += 1
            
        return -1