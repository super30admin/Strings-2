# Time Complexity: O(n) where n is the length of haystack
# Space Complexity: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0  # per problem definition

        # Step 1: Build the LPS array
        def build_lps(pattern):
            lps = [0] * len(pattern)
            length = 0  # length of the previous longest prefix suffix
            i = 1
            while i < len(pattern):
                if pattern[i] == pattern[length]:
                    length += 1
                    lps[i] = length
                    i += 1
                else:
                    if length != 0:
                        length = lps[length - 1]  # fallback
                    else:
                        lps[i] = 0
                        i += 1
            return lps

        lps = build_lps(needle)
        print(lps)
        # Step 2: Perform the KMP search
        i = j = 0  # i -> haystack, j -> needle
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            if j == len(needle):
                return i - j  # match found
            elif i < len(haystack) and haystack[i] != needle[j]:
                if j != 0:
                    j = lps[j - 1]  # use lps to avoid rechecking
                else:
                    i += 1

        return -1  # no match found