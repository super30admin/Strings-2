# TC: O((H - N)N)
# SC: 0(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if needle == "":
            return 0
        if len(needle) > len(haystack):
            return -1
        
        n = len(needle)
        h = len(haystack)
        
        for i in range(h-n+1):
            needle_idx = 0
            flag = True
            for k in range(i, i+n):
                if haystack[k] == needle[needle_idx]:
                    needle_idx += 1
                else:
                    flag = False
                    break
            if flag:
                return i
        
        return -1