class Solution:
    
    """
    Description: Return the index of the first occurrence of needle in haystack
    
    Time Complexity: O(n + m)
    Space Complexity: O(m)
    
    Approach: using LPS array (KMP algorithm)
    - build an array that tells us where these proper prefixes that are also suffixes of the needle occur and we use that to optimize our searches
    - when mistmatch is found and not on the first index, look for LPS value before it to know how many characters can be skipped in needle
    - begine comparison of mismatch characters following the last skipped character
    - if mismatch occurs at first character we move the needle to the next character in haystack
    
    - Compare the needle and haystack in similar way to find the index if match is found (main function)
    """
    
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(haystack) < len(needle): return -1
        if len(haystack) == 0 or len(needle) == 0: return 0
        
        lps = self.lpsGenerator(needle)
        
        i = 0; j = 0
        while i < len(haystack):
            if needle[j] == haystack[i]:
                i += 1; j += 1
                if j == len(needle): return i - j
            elif j > 0 and needle[j] != haystack[i]:
                j = lps[j - 1]
            elif j == 0 and needle[j] != haystack[i]:
                i += 1
        
        return -1
    
    def lpsGenerator(self, needle):
        
        n = len(needle)
        i = 1; j = 0
        lps = [0] * n 

        while i < n:
    
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1

            elif j > 0 and needle[i] != needle[j]:
                j = lps[j - 1]
                
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
                
        return lps
    
    # BRUTE FORCE Solution:
    
    # def strStr(self, haystack: str, needle: str) -> int:

    #     if len(needle) == 0: return 0
    #     if len(haystack) < len(needle): return -1
    #     start = 0
 
    #     while start < len(haystack): 
    #         substr = haystack[start: start+len(needle)]
    #         if len(substr) == len(needle) and all([i == j for i, j in zip(needle, substr)]):
    #             return start
    #             break
    #         start += 1

    #     return -1
