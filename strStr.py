# Approach: Sliding window. We start iterating over haystack str and if we see matching character with
# first char in needle, then we start expanding both haystack and needle pointers till we don't find 
# matching character. If we found character that don't match, we break, move haystack pointer to same place
# where it last matched the first character of needle. Then outer loop will move pointer to one place forward
# and try matching string all over again, move needle pointer to also 0 again.
# TC : O(n)
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
                    