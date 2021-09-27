class Solution:
    """
    TC - O(m+n)
    SC - O(n)
    """
    def strStr(self, haystack: str, needle: str) -> int:
        def do_lps(needle):
            lps = [0] * len(needle)
            i = 1
            j = 0
            while i<len(needle):
                if needle[i] == needle[j]:
                    j += 1
                    lps[i] = j
                    i += 1
                else:
                    if j > 0:
                        j = lps[j-1]
                    else:
                        lps[i] = 0
                        i += 1
            return lps
        if not haystack and not needle:
            return 0
        if not needle:
            return 0
        m = len(haystack)
        n = len(needle)
        i = 0
        j = 0
        lps = do_lps(needle)
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            else:
                if j>0:
                    j = lps[j-1]
                else:
                    i+=1
        return -1
        