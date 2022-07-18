class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # KMP Algorithm for pattern finding
        # https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
        # TC - O(n) SC - O(1)
        m = len(needle)
        n = len(haystack)

        lps = [0] * m
        j = 0  # index for needle

        if n < m:
            return -1

        # preprocess lps needle
        self.computeLPS(needle, m, lps)

        i = 0  # index for haystack
        while i < n:
            if needle[j] == haystack[i]:
                i += 1
                j += 1

            if j == m:
                return i - m

            # mismatch after j matches
            elif i < n and needle[j] != haystack[i]:
                if j > 0:
                    j = lps[j - 1]
                elif j == 0:
                    i += 1
        return -1

    def computeLPS(self, needle, m, lps):
        j = 0  # len of previous longest proper prefix suffix
        lps[0] = 0
        i = 1
        while i < m:
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1

    '''
        # Brute Force O((m-n)*(n)) = O(mn) 
        # SC = O(1)
        m = len(haystack)
        n = len(needle)

        if n == 0:
            return 0
        if m < n:
            return -1
        for i in range(m-n+1):
            if haystack[i:i+n] == needle:
                return i
        return -1
    '''

