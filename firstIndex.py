"""
Build the LPS (Longest Prefix Suffix) array for needle
Use LPS array while scanning the haystack to skip redundant comparisons
Return start index if full match is found; else return -1
"""
"""
Time Complexity: O(n + m) - n = len(haystack) ; m = len(needle)
Space Complexity: O(m) - lps[] array of size m
"""


class firstIndex:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0

        def buildLPS(pattern):
            lps = [0] * len(pattern)
            length = 0
            i = 1
            while i < len(pattern):
                if pattern[i] == pattern[length]:
                    length += 1
                    lps[i] = length
                    i += 1
                else:
                    if length != 0:
                        length = lps[length - 1]
                    else:
                        lps[i] = 0
                        i += 1
            return lps

        lps = buildLPS(needle)

        i = j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - j
            else:
                if j != 0:
                    j = lps[j - 1]
                else:
                    i += 1

        return -1

if __name__ == "__main__":
    obj = firstIndex()
    print(obj.strStr("sadbutsad", "sad"))     
    print(obj.strStr("leetcode", "leeto"))    
    print(obj.strStr("abcxabcdabcdabcy", "abcdabcy")) 
