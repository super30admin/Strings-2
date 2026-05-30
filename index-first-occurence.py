# time: O(n*m)
# space: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l=0
        k=0
        r=0
        while r < len(haystack):
            if needle[k] == haystack[r]:
                if r-l+1 == len(needle):
                    return l
                k+=1
                r+=1
            else:
                l+=1
                r=l
                k=0
        
        return -1


# O(n)