# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    # O(mxn) solution, Time limit exceeded. (Brute Force)
    # def strStr(self, haystack, needle):
    #     if len(needle) == 0:
    #         return 0
    #     if len(needle) > len(haystack) :
    #         return -1
        
    #     i = 0 
    #     index = float('inf')
    #     flag = False
    #     while i < len(haystack):
    #         j = 0 
    #         temp = i
    #         while i < len(haystack) and j < len(needle):
    #             if haystack[i] == needle[j]:
    #                 if index >= i:
    #                     index = i 
    #                 i += 1 
    #                 j += 1 
    #             else:
    #                 j = 0 
    #                 index = float('inf')
    #                 break
    #         if j == len(needle):
    #             return index 
    #         i = temp 
    #         i += 1 
    #     return -1 
    
    # Time = O(n) | Space = O(m) where m is the length of needle, in worst can be = n.
    def strStr(self, haystack, needle):
        if  len(needle) == 0:
            return 0 
        i = 0
        j = 0
        lps = self.__lps(needle)            # O(m)
        while i < len(haystack):            # O(n)
            if haystack[i] == needle[j] :
                i += 1 
                j += 1 
            
            if j == len(needle):
                return i - j 
            
            elif (i < len(haystack) and j > 0 and haystack[i] != needle[j]):
                j = lps[j-1]
            
            elif (i < len(haystack) and j == 0 and haystack[i] != needle[j]):
                i += 1
        
        return -1
    
    def __lps(self,needle):
        i = 1
        j = 0 
        lps = [0] * len(needle)
        
        while i < len(needle):
            if needle[i] == needle[j] :
                j += 1 
                lps[i] = j
                i += 1 
            
            elif (j > 0 and needle[i] != needle[j]):
                j = lps[j-1]
            
            elif (j==0 and needle[i] != needle[j]):
                lps[i] = 0 
                i += 1 
        
        return lps

if __name__ == "__main__":
    s = Solution()

     # test case 1 : 
    haystack = "mississippi"
    needle = "issipi"                    
    res = s.strStr(haystack, needle)
    print(res)
    
        