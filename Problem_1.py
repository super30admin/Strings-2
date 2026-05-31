class Solution:
    def strStr(self, haystack, needle):
        hl, nl = len(haystack), len(needle)
        if nl > hl:
            return -1
        for i in range(hl - nl + 1):
            if haystack[i] == needle[0]:
                if self.helper(haystack, needle, i):
                    return i
        return -1

    def helper(self, haystack, needle, i):
        j = 0
        while i < len(haystack) and j < len(needle):
            if haystack[i] != needle[j]:
                return False
            i += 1
            j += 1
        return j == len(needle)
