"""28. Implement strStr()
Time Complexity:O(n)
Space Complexity:O(n)
Approach - KMP"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        
        lps = self.lps(needle)
        i = 0
        j = 0
        m = len(haystack)
        n = len(needle)
        while(i<m):
            if haystack[i]==needle[j]:
                j+=1
                i+=1
                if j == n: #last 
                    return i-j
            elif j>0 and haystack[i] != needle[j]:
                j = lps[j-1]
            elif j==0 and haystack[i] != needle[j]:
                i+=1
        return -1
    
    def lps(self,needle):
        i, j = 1,0
        lps = [0]* len(needle)
        while i < len(needle):
            if needle[i]==needle[j]:
                j +=1
                lps[i] = j
                i +=1

            elif j>0 and needle[i] != needle[j]:
                j = lps[j-1]

            elif j==0 and needle[i] != needle[j]:
                lps[i]=0
                i+=1

        return lps