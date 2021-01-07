"""
Approach: Bruteforce

A normal brute force apporach would be put to check for the same consecutive characters in both the strings. 

We take two pointers. One pointing to haystack and one to needle. We run a loop on both. Outerloop on haystack to check for the matching needle from current character and inner loop on needle to check for each character from the chacracter pointed in haystack. If any mismatch occurs, we break the loop. If at any point we reach the end of thr needle that means we have found all the characters and we return the position of the pointer that is pointing the current character in haystack.

Time complexity: O(m x n)
Space complexity: O(1)

n = length of haystack
m = length of needle
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == None or len(needle) == 0:
            return 0
        
        if len(haystack) < len(needle):
            return -1
        
        for i in range(len(haystack) - len(needle) + 1):
            k = i
            j = 0
            while j < len(needle):
                if haystack[k] != needle[j] :
                    break
                k += 1
                j += 1
                
            if j == len(needle):
                return i
            
        return -1

"""
Approach: Using KMP(Knuth–Morris–Pratt algorithm) for pattern searching and LPS(Longest Prefix which is also a Suffix)

visit https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/ for detailed exaplaination

TC: O(n)
SC: O(m)

n = length of haystack
m = length of needle
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == None or len(needle) == 0:
                return 0

        if len(haystack) < len(needle):
            return -1  
        
        lps = [0] * len(needle)
        self.computeLPS(needle, lps)
        
        i = 0
        j = 0
        
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                
                if j == len(needle):
                    return i - len(needle)
                
            elif haystack[i] != needle[j]:
                if j > 0:
                    j = lps[j-1]
                else:
                    i += 1
        return -1
        
    # Computing LPS(Longest Prefix which is also a Suffix)
    # TC: O(m); m = length of needle
    def computeLPS(self, needle, lps):
        i = 1
        j = 0
        
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j]:
                if j>0:
                    j = lps[j - 1]
                else:
                    lps[i] = 0
                    i += 1
