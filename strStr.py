# Approach: Sliding window. We start iterating over haystack str and if we see matching character with
# first char in needle, then we start expanding both haystack and needle pointers till we don't find 
# matching character. If we found character that don't match, we break, move haystack pointer to same place
# where it last matched the first character of needle. Then outer loop will move pointer to one place forward
# and try matching string all over again, move needle pointer to also 0 again.
# TC : O(m*n)
# SC : O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        if len(needle) > len(haystack): return -1
        
        hptr, nptr = 0, 0
        
        while hptr < len(haystack) and nptr < len(needle):
            if haystack[hptr] == needle[nptr]:
                matchIndex = hptr
                while hptr < len(haystack) and nptr < len(needle):
                    if haystack[hptr] != needle[nptr]:
                        nptr = 0
                        hptr = matchIndex
                        matchIndex = -1
                        break
                    nptr += 1
                    hptr += 1
                # when the loop ended if we didn't reset needle pointer,
                # means we found result, return it
                if nptr == len(needle):
                    return matchIndex
            hptr += 1
        return -1
                    

# Approach: KMP Algorithm
# TC : O(m+n) 
# SC : O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if needle == "": return 0
        n = len(needle)
        lps = [0] * n  # populate LPS array with 0s

        # calculate LPS for needle
        # prevLPS is is our index, read it like j of i,j pair
        prevLPS, i = 0, 1
        while i < n:
            # if current char matches what prevLPS
            # is pointing to
            if needle[i] == needle[prevLPS]:
                # then set curr lps to index prevLPS+1
                lps[i] = prevLPS + 1
                # increment both pointers
                prevLPS += 1
                i += 1
            elif prevLPS == 0:
                # this is the case when prevLPS kept moving
                # backward and eventually reached the beginning
                # we couldn't find any char in needle[prevLPS] that
                # matched with needle[i]
                lps[i] = 0  # we have no longest common prefix-suffix for ith index
                i += 1
            else:
                # this is the case where we can't find matching chars at i and prevLPS
                # so we use lps array to decide next location where prevLPS should move 
                # to - in the backward direction
                prevLPS = lps[prevLPS-1]
        
        # now that we have our LPS array populated we need to run KMP algo
        # we will set a pointer i at index 0 on haystack and j on 0th in needle
        # start comparing them and move them forward
        i = j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]: # simple case, chars match, keep moving fwd
                i += 1
                j += 1
            else: # chars didn't match
                if j == 0: # we are at the beginning of the needle
                    i += 1 # so let's move our i fwd
                else: # instead of resetting j to 0, set it to lps[j-1]
                    # that moves our j to that point where we already know
                    # characters were matching
                    j = lps[j-1]
            # check j bounds
            if j == len(needle):
                return i - len(needle)
        return -1
            