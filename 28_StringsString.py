# 1st Solution
# Time Complexity: O(n^2)
# 2nd Solution
# Time Complexity: O(n)

class Solution:

    # Brute Force
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        i = 0 # haystack pointer
        j = 0 # needle pointer
        while(i <= (m - n)):
            if haystack[i] == needle[j]:
                k = i
                while haystack[k] == needle[j]:
                    j +=1
                    k +=1
                    if j == n:
                        return i
                j = 0
            i +=1
        
        return -1

    def strStr2(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if m < n:
            return -1
        i = 0 # haystack pointer
        j = 0 # needle pointer  
        lps = self.lps(needle)
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i- n
            elif j != 0:
                j = lps[j-1]
            else:
                i += 1 #magic of KMP Algo - not resetting i
        return -1
    
    
    def lps(self,needle):
        j = 0
        i = 1
        lps = [None] *len(needle)
        lps[0] = 0
        while i < len(needle):
            if needle[j] == needle[i] :
                j +=1
                lps[i] = j
                i +=1
            else:
                if j > 0:
                    j = lps[j-1]
                elif j == 0:
                    lps[i] = 0
                    i +=1
                
        return lps
                    
obj = Solution()
print(obj.strStr2("mississippi","issip"))