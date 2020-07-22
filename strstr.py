# brute force solution
# O(mn) time | O(1) space
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        if n==0: return 0
        
        p1, nptr = 0, 0
        while p1 < len(haystack)-n+1:
            if haystack[p1] == needle[nptr]:
                p2 = p1
                while nptr<n:
                    if haystack[p2] == needle[nptr]:
                        p2+=1
                        nptr+=1
                        if nptr==n:
                            return p1
                    else:
                        nptr=0
                        break
            p1+=1
        
        return -1