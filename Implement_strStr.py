# Time Complexity : O(M+N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using KMP Longest Common Prefix Suffix
# First we need to get the lps on needle string
# Once we got the lps then we need to iterate on main string haystack where i = 0 and j = 0 in needle string
# If the character at i and character at j are equal then we increment i by 1 and j by 1 and if j reaches the end then return i - len(needle) that is j
# If the characters are not equal and j > 0 then j = lps[j-1]
# If the characters are not equal and  j == 0 then increment i by 1
# If no match is found return -1
# Another approach is Robin Karp rolling hash
# We calculate the hash for needle
# We traverse the haystack and calculate the hash for haystack upto the length of needle
# If the length exceeds the needle we remove one character from left and add one character to right and calculate hash for outgoing and incoming character
# Then we check if needle hash == haystack hash if it is then return i-m+1 else return -1

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(needle)
        n = len(haystack)
        if m > n:
            return -1
        for i in range(n-m+1):
            s = haystack[i:i+m]
            if s == needle:
                return i
        return -1
#Time - O(mn)
#Space - O(m)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(needle)
        n = len(haystack)
        if m > n:
            return -1
        for i in range(n-m+1):
            j = 0
            if haystack[i] == needle[j]:
                j += 1
            while j < m and haystack[i + j] == needle[j]:
                j += 1
            if j == m:
                return i
        return -1
#Time - O(mn)
#Space - O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        result = self.lps(needle)
        i = 0
        j = 0
        while i < len(haystack):
            if j > 0 and haystack[i] != needle[j]:
                j = result[j-1]
            elif j == 0 and haystack[i] != needle[j]:
                i += 1
            else:
                i += 1
                j += 1
            if j == len(needle):
                return i - j
        return -1


    
    def lps(self, needle):
        lpsarr = [0] * len(needle)
        i = 1
        j = 0
        while i < len(needle):
            if j > 0 and needle[i] != needle[j]:
                j = lpsarr[j-1]
            elif j == 0 and needle[i] != needle[j]:
                i += 1
            else:
                j += 1
                lpsarr[i] = j
                i += 1
        return lpsarr
#Time - O(n + m)
#Space - O(m)


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(needle)
        n = len(haystack)
        if m == 0:
            return 0
        if m > n:
            return -1
        phash = 0
        for i in range(m):
            ch = needle[i]
            phash = phash * 26 + (ord(ch) - ord('a') + 1)
        shash = 0
        for i in range(n):
            #outgoing character
            if i >= m:
                ch = haystack[i-m]
                shash = shash - (ord(ch) - ord('a') + 1) * 26 ** (m-1)
            #incoming character
            c = haystack[i]
            shash = shash * 26 + (ord(c) - ord('a') + 1)
            if phash == shash:
                return i-m+1
        return -1
#Time - O(m+n)
#Space - O(1)