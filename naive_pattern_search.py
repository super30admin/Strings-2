"""
Time Complexity : O(m*n) where m is the length of haystack and n is the length of needle. 
Space Complexity : O(1). We are not using any auxillary data structure. Only using pointers

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
1. Iterate through the both the haystack (i=0, j=0) and needle(k=0) one by one by moving j and k pointers respectively.
2. If the characters at j and k index are different then reset k to 0 and j to i + 1 and i = i+1
3. At the end if we reach k to len(needle) return i 
4. If we don't find any pattern return -1.
"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        i = j = k = 0

        m = len(haystack)
        n = len(needle)

        """
        hatstack = aaaabaaa
        needle = aaabaaa
        """
        for i in range(m-n+1):
            while k < n and j < m and haystack[j] == needle[k]:
                j += 1
                k += 1
            if k == n:
                return i
            j = i + 1
            k = 0

        return -1
