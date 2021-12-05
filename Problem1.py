#leetcode 28: Implement strStr()
# Time - O(n)
# Space - O(n)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        n = len(haystack)
        m = len(needle)

        if needle == "":
            return 0

        lps = [0] * m
        
        def computeLPS(needle, m, lps):
            ptr1 = 0
            ptr2 = 1
            lps[0] = 0
            
            while(ptr2 < m):
                
                if needle[ptr2] == needle[ptr1]:
                    lps[ptr2] = ptr1 + 1
                    ptr1 += 1
                    ptr2 += 1
                    
                else:
                    if ptr1 != 0:
                        ptr1 = lps[ptr1 - 1]
                    else:
                        
                        lps[ptr2] = 0
                        ptr2 += 1
                       
        computeLPS(needle, m, lps)
        
        i = 0
        j = 0
        
        while(i < n):
            
            if haystack[i] == needle[j]:
                
                i = i + 1
                j = j + 1
                
            else:
                if j != 0:
                    j = lps[j - 1]   
                else:
                    i = i + 1
                    
            if j == m:
                return i - j
        
        return -1