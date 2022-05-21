class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l1, l2 = len(haystack) , len(needle)
        if needle==None: return 0 
        if haystack==None or l1<l2: return -1
        
        for i in range(l1-l2+1):
            if haystack[i:i+l2] == needle: 
                return i 
        return -1 