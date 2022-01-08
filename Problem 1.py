# Time Complexity: O(m+n)
# Space Complexity: O(m)
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) == 0:
            return 0
        lps = self.lps(needle)
        i = 0
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - len(needle)
            elif haystack[i] != needle[j] and j != 0:
                j = lps[j-1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1
            
        return -1
    def lps(self, needle):
        lps = [0]*len(needle)
        lps[0] = 0
        i = 1
        j = 0
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j != 0:
                j = lps[j-1]
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1
        return lps
                
        
