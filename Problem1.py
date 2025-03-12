# Problem 1 : Find the Index of the First Occurrence in a String
# Time Complexity : O(m*n) where m is the length of the haystack and n is the length of the needle
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # get the length of the both the strings
        lengthN = len(needle)
        lengthH = len(haystack)
        # initialize the start pointer
        start = 0
        # if the length of the needle is greater than haystack then we can not find the first occurence in a string so return -1
        if len(needle) > len(haystack): return -1
        
        # loop through the string from 0 to len(haystack) - len(needle) in the string haystack
        while (start <= (lengthH - lengthN)):
            # if the first character of needle is equal to the character at start position of string s
            if (haystack[start] == needle[0]):
                # set the end pointer to start pointer and pointerN to 0 for the needle
                end = start 
                pointerN = 0
                # continue till the character of haystack at end position and needle at pointerN position are equal
                while (haystack[end] == needle[pointerN]):
                    # increment the end and pointerN pointer
                    end += 1
                    pointerN += 1
                    # if the pointerN is equal to size of the needle string then resturn start
                    if pointerN == lengthN:
                        return start
            
            # increment the start pointer
            start += 1
        # if there is no occurence then return -1
        return -1