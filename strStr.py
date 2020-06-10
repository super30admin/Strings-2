#Time Complexity:O(mxn)
#Space complexity:O(1)
#Ran successfully on leetcode:Yes
#Algorithm:
#Check if the needle exists as a substring in haystack and return the first index of the occurence.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # #base 
        if len(needle)==0:
            return 0
        for x in range(0,len(haystack)-len(needle)+1):
            if haystack[x:x+len(needle)]==needle:
                return x
        return -1
     
