#Implement strStr()
# // Time Complexity :  O(N*M) 
# // Space Complexity : O(1)- as the max elements will only be 26 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
#could be optimized more using the KMP method


def strStr(self, haystack: str, needle: str) -> int:
        
    if needle=="":
        return 0
    for i in range(len(haystack) - len(needle)+1):      
        if haystack[i:i+len(needle)]==needle:       #for every substring of the length of needle in haystack, check if it equals to the needle
            return i
    return -1

