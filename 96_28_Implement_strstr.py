# Done July 26, 2020
# Learnt vey important algo KMP

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        # Method 2 : KMP algorithm
        # Time complexity : O(n)
        # Space complexity : O(n)
        # to create an array equivalent to haystack length

        # does not work yet,  yet to fix

        if not needle: return 0
        m = len(haystack)
        n = len(needle)
        self.lps = []  # O(n)
        i = 0
        j = 0
        while i < m:  # O(m)
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            if j == n: return i - n
            if i < m and haystack[i] != needle[j]:
                j = self.kmp(j - 1)
            elif i < m and j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1

    def kmp(self, needle):

        self.lps[0] = 0
        j = 0
        i = 1
        while i < len(needle):
            if needle[j] == needle[i]:
                j += 1
                self.lps[i] = j
                i += 1
            elif j > 0 and needle[j] != needle[i]:
                j = lps[j - 1]  # this is not j-1, its lps[j-1]
            elif j == 0 and needle[j] != needle[i]:
                self.lps[i] = 0
                i += 1
        return self.lps

        # Method 1 : Brute force
        # Time complexity : O( m * n)
        # for every char in 'm;, I look for the entire pattern in 'n', if it does not match I come back.
        # Space complexity : O(1), no space used

        # for every letter mismatched come back to 0th index of needle
        '''
        # if not haystack and not needle: return 0
        if not needle: return 0 # if subset of string is just an empty string we return 0, basically 1st index.
        # if both are empty it still returns 0 ( "", "")

        # Since I want to move two pointers together I cannot use two for loops
        # Hence I use one while loop so that I can use both together
        j = 0
        for curr in range(len(haystack)): # len(m) # 0 1 2 3 4
            if haystack[curr] == needle[j]: # j starts here from 0 for fresh curr
                temp = curr
                # j = 0 here
                while temp<len(haystack) and j<len(needle):
                    if haystack[temp] == needle[j]:
                        temp+=1
                        j+=1
                    else:
                        break


                if j == len(needle):
                    return curr
                # once a mismatch found, we rstore the needle pointer to 0
                j = 0 # we re-intialise the value to 0, if we come across non matched chars half way in needle

        return -1

        '''






