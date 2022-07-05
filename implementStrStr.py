'''
Time Complexity: 0(needle) + 0(haystack)
Space Complexity: O(needle)
Run on leetCode: Yes
'''
class Solution:
    
    def __longestCommonPrefixSuffix(self,needle):
        
        # initialize lcps list
        lcps = [None]*len(needle)
        lcps[0] = 0
        
        # initialize ptr's
        j = 0  #  for prefix
        i = 1  #  for suffix
        
        while i != len(needle):
            
            # Case: chars are same
            if needle[j] == needle[i]:
                j = j+1
                lcps[i] = j
                i = i+1
            
            # Case: chars are different
            elif needle[j] != needle[i]:
                while j>0 and (needle[j] != needle[i]):
                    j = lcps[j-1]
                
                if j==0 and (needle[j] != needle[i]):
                    lcps[i] = j
                    i = i+1
        '''end of while loop'''
        
        # print("LCPS List is:\t",lcps)
        return lcps
        
    def strStr(self, haystack: str, needle: str) -> int:
        
        #   edge case check
        if (len(needle) == 0):
            return 0

        #   intializations and PI array fillings
        hs = len(haystack)
        n = len(needle)
        pi = self.__longestCommonPrefixSuffix(needle)

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