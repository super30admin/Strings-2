# 28. Implement strStr()

# Time Complexity: O(n*m)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: 78/80 test cases passed; time limit exceeded
# Any problem you faced while coding this: No

# Approach: match the 1st letter of the string and keep matching the other letters until needle is found in haystack

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        # Brute Force Solution
        
        # testcase 1: needle is an empty string
        if not needle or len(needle) == 0:
            return 0
        
        if len(haystack) < len(needle):
            return -1
        
        # needle not found -> return -1 
        
#         "haystack" -> 8
#         "ayt" -> 3
        
#         j = 1 < 4

#         j = 3, k = 2

        # if len(needle) > len(haystack)
        
        
        i = 0
        while(i< len(haystack)-len(needle)+1):
            k = 0
            if haystack[i] == needle[k]:
                
                j = i
                while(j < i+len(needle) and j < len(haystack)):
                    if haystack[j] != needle[k]:
                        break
                    j+=1
                    k+=1
                
                if k == len(needle):
                    return i
            i = i+1
        return -1 

# Time Complexity: O(n)
# Space Complexity: O(n*m) -> makes several copies of the string slice
# Did this code successfully run on Leetcode: All test cases passed
# Any problem you faced while coding this: No

# Approach: Use list comprehensions/ string slicing to find the string match between haystack and needle


class Solution:
    
    def strStr(self, haystack, needle):
        if needle == "":
            return 0
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i:i+len(needle)] == needle:
                return i
                
        return -1