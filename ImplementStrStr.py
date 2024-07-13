# Time Complexity : O(m*n)
# Space Complexity : O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack is None or needle is None or len(haystack) == 0 or len(needle) == 0:
            return -1
        
        n = len(haystack)
        m = len(needle)

        if haystack == needle:  # both strings are the same
            return 0

        for i in range(n):
            if haystack[i] == needle[0] and i + m <= n:  # beginning character match
                if haystack[i:i + m] == needle:
                    return i

        return -1

# Examples
solution = Solution()

haystack1 = "hello"
needle1 = "ll"
print(solution.strStr(haystack1, needle1))  # Expected output: 2

haystack2 = "aaaaa"
needle2 = "bba"
print(solution.strStr(haystack2, needle2))  # Expected output: -1

haystack3 = ""
needle3 = ""
print(solution.strStr(haystack3, needle3))  # Expected output: -1

haystack4 = "abc"
needle4 = "abc"
print(solution.strStr(haystack4, needle4))  # Expected output: 0

haystack5 = "mississippi"
needle5 = "issip"
print(solution.strStr(haystack5, needle5))  # Expected output: 4