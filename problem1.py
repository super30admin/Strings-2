# Approach1: Brute Force
# time complexity: O(n*m)
# space complexity: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle: 
            return 0
        
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1


# Approach2: KMP Algorithm
# time complexity: O(n+m)
# space complexity: O(m)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle: 
            return 0
        
        def compute_lps(needle):
            lps = [0]*len(needle)
            j=0
            i=1

            while i<len(needle):
                if needle[j] == needle[i]:
                    lps[i] = j+1
                    j+=1
                    i+=1
                elif j != 0:
                    j = lps[j-1]
                else:
                    i += 1
            return lps

        lps = compute_lps(needle)
        i = 0 # Index for haystack
        j = 0 # Index for needle

        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1

                if j == len(needle):
                    return i-j
            elif j != 0:
                j = lps[j-1]
            else:
                i += 1
        return -1