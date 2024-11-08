# 28. Find the Index of the First Occurrence in a String
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) > len(haystack):return -1
        n = len(haystack)
        result = -1
        i = 0
        while i <= (len(haystack) - len(needle)):
            j = 0
            if haystack[i] == needle[j]:
                k = i
                while haystack[k] == needle[j]:
                    k += 1
                    j += 1
                    if j == len(needle):
                        return k-len(needle)
            i += 1
                    
        return result
        