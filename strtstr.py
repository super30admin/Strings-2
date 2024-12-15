"""
Rolling hash technique
TC: O(m+n) m -->len (haystack) n--> needle
SP:O(1)
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needle_hash = 0
        k = len(needle)
        for n in needle:
            needle_hash = needle_hash *26 + ord(n)-ord('a') +1 
        hay_hash = 0
        l = 0
        for i, h in enumerate(haystack):
            hay_hash = hay_hash *26 + ord(h)-ord('a') +1 

            if i-l+1==k:

                if hay_hash==needle_hash:
                    return l

                hay_hash = hay_hash - (ord(haystack[l])-ord('a') +1) * pow(26, k-1)
                l+=1
        return -1


            

            
        
        