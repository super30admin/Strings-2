# Time O(n*m)
# Space O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # brut force 
        n, m = len(haystack), len(needle)
        for i in range(n - m + 1):
            j = i
            for c in needle:
                if c != haystack[j]: break
                j += 1
            if j == i + m: return i
        return -1

# Time O(n+m)
# Space O(1)   
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # KMP algo
        n, m = len(haystack), len(needle)
        needleHash = 0
        for c in needle:
            needleHash = needleHash * 26 + ord(c)
        haystackHash = 0
        for i in range(n):
            # out
            if i >= m:
                haystackHash = haystackHash - (ord(haystack[i - m]) * pow(26, m-1))
            # in
            haystackHash = haystackHash * 26 + ord(haystack[i])
            if haystackHash == needleHash: return i - m + 1
        return -1