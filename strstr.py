#As taught in class using kmp algorithm to solve the problem (using longest common prefix and suffix)
#Time compexity: O(m+n)
#Space Complexity: O(n)
class Solution:
    def lps(self,needle):
        j = 0
        i = 0
        lps = [0]*len(needle)
        while(i<len(needle)):
            if needle[i] == needle[j]:
                j = j + 1
                lps[i] = j
                i = i + 1
            elif (j >0 and needle[i] == needle[j]):
                j = lps[j-1]
            elif (j==0 and needle[i] == needle[j]):
                lps[i] = 0
                i = i + 1
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0:
            return 0
        m = len(haystack)
        n = len(needle)
        i = 1
        j = 0
        if m < n:
            return -1
        lps = self.lps(needle)
        while i < m :
            if haystack[i] == needle[j]:
                i = i + 1
                j = j + 1
                if j == n:
                    return i -n
                elif i<m and j >0 and haystack[i] != needle[j]:
                    j = lps[j-1]
                elif i < m and j == 0 and haystack[i] != needle[j]:
                    i = i  + 1
        return -1