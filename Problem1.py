'''
Problem:  Find the Index of the First Occurrence in a String
Time Complexity: O(n + m), where n is length of needle and m is length of haystack
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        rabin karp algorithm of rolling hash
        at the end comparing needle hash with substring of haystack using sliding window
'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n1 = len(haystack)
        n2 = len(needle)

        if n2>n1:
            return -1

        needlehash = 0
        #rolling hash of needle(pattern)
        for i in range(n2):
            needlehash = needlehash * 26 + (ord(needle[i]) - ord('a') + 1)
        
        hayhash = 0
        for i in range(n1):
            #in
            hayhash = hayhash * 26 + (ord(haystack[i]) - ord('a') + 1)

            #out
            if i>=n2:
                outchar = haystack[i - n2]
                #get number associated * 26 power length of needle
                hayhash-= (ord(outchar)-ord('a')+1) * (26**n2)

            if needlehash == hayhash:
                return i-n2+1
        
        return -1