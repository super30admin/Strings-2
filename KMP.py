'''
Solution:
1.  Perform KMP Algorithm whose main idea is to avoid repetitive checks for indices in needle,
    where there is a prefix for a given suffix.
2.  For that purpose, create a pi array which indicates the presence of prefix for a given
    suffix.

Time Complexity:    O(n + m) n - length of haystack and m - length of needle
Space Complexity:   O(m)

--- Passed all the testcases on Leetcode successfully
'''


class KMP:
    
    def __computePI(self, needle: str) -> List[int]:
        
        #   initialize PI array withfirst index to be zero and to update the rest indices
        pi = [0 for i in range(len(needle))]
        j = 0
        i = 1
        
        #   iterate till i doesn't cross the length of the needle
        while (i < len(needle)):
            
            #   if chars at i and j match => increment j, assign ith index as j and increment i
            if (needle[i] == needle[j]):
                j += 1
                pi[i] = j
                i += 1
            
            #   if they won't match, assign j to the value at pi[j - 1] till you hit either 
            #   equality case or hit j = 0 case.
            else:
                if (j == 0):
                    i += 1
                else:
         
                    j = pi[j - 1]

        #   return the resultant array
        return pi
    
    def strStr(self, haystack: str, needle: str) -> int:
        
        #   edge case check
        if (len(needle) == 0):
            return 0
        
        #   intializations and PI array fillings
        hs = len(haystack)
        n = len(needle)
        pi = self.__computePI(needle)
        
        i = 0
        j = 0

        #   iterate till i doesn't cross the length of the haystack
        while (i < hs):
            
            #   if chars at i and j match => increment j, increment i
            if (haystack[i] == needle[j]):
                i += 1
                j += 1
                if (j == n):            #   terminating condition meaning index found
                    return i - j
            
            #   if they won't match, assign j to the value at pi[j - 1] till you hit either 
            #   equality case or hit j = 0 case.      
            else:
                if (j == 0):
                    i += 1
                else:
                    j = pi[j - 1]
          
        #   return -1 if not found          
        return -1
            