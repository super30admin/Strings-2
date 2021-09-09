# Time Complexity: O(m + n), where m - length of haystack, n - length of needle
# Space Complexity: O(n)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle or len(needle) == 0:
            return 0

        lps = self.lps(needle)

        i = j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - len(needle)

            elif j > 0 and haystack[i] != needle[j]:
                j = lps[j - 1]

            elif j == 0 and haystack[i] != needle[j]:
                j = 0
                i += 1

        return -1

    def lps(self, needle: str) -> List[int]:
        lps = [0 for x in range(len(needle))]
        i = 1
        j = 0

        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1

            elif j > 0 and needle[i] != needle[j]:
                j = lps[j - 1]

            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1

        return lps