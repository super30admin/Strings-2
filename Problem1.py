'''

Time Complexity :
Brute force O(m x n)
Rabin Karp O(m + n)
KMP algo O(m + n)

Space Complexity :
O(1) for all

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

In Brute force approach we are comparing at each length if the string is matching
In Rabin Karp we calculate a rolling hash and check if at any point the rolling hash matches
In KMP, we calculate Longest prefix suffix array to keep track of repeating elements and thereby use it to find the repeating elements

'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        # Brute-force approach
        '''for i in range(len(haystack)-len(needle)+1):
            if haystack[i] == needle[0]:
                for j in range(len(needle)):
                    if haystack[i] != needle[j]:
                        break
                    elif j == len(needle)-1:
                        return i - j
                    i += 1

        return -1'''

        # 2nd Method Using Rabin-Karp
        '''rolling = 0
        for c in needle:
            rolling = (rolling * 26) + (ord(c)-ord('a')+1)

        m = len(haystack)
        n = len(needle)
        out = 26 ** (n-1)
        sum = 0
        
        for i in range(m):
            if i > n - 1:
                sum = sum - (out * (ord(haystack[i-n]) - ord('a') + 1))
                
            sum = (sum * 26) + (ord(haystack[i]) - ord('a') + 1)

            if sum == rolling:
                return i - n + 1
        return -1'''

        # KMP approach
        if not needle: return 0
        lps = [0] * len(needle)

        prevLPS, i = 0,1

        while i < len(needle):
            if needle[prevLPS] == needle[i]:
                lps[i] = prevLPS + 1
                i += 1
                prevLPS += 1
            elif prevLPS == 0:
                lps[i] = 0
                i += 1
            else:
                prevLPS = lps[prevLPS-1]


        i = 0
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i,j = i+1,j+1
            else:
                if j == 0:
                    i += 1
                else:
                    j = lps[j-1]
            if j == len(needle):
                return i - j
        return -1

