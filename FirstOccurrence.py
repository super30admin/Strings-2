# Time Complexity : O(m + n) where m is haystack.length() and n is needle.length()
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, we compute the hash of the needle using base 26. Then we slide a window over haystack and update its hash each time.
# If any window's hash matches the needle, we return the start index.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)

        pHash = 0

        for i in range(n):
            ch = needle[i]
            pHash = pHash * 26 + ord(ch) - ord('a') + 1
        
        currHash = 0

        for i in range(m):
            ch = haystack[i]
            currHash = currHash * 26 + ord(ch) - ord('a') + 1

            if i >= n:
                c_out = haystack[i - n]
                currHash = (currHash - ((26 ** n) * (ord(c_out) - ord('a') + 1)))

            if currHash == pHash:
                return i - n + 1

        return -1