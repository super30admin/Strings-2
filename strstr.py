# brute force solution
# O(mn) time | O(1) space
# using a sliding window. 
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        if n==0: return 0
        
        # we keep two pointers to traverse both the strings.
        p1, nptr = 0, 0
        while p1 < len(haystack)-n+1:
            if haystack[p1] == needle[nptr]:
                p2 = p1                 # use a new tmp pointer to compare the substring. this is done to not lose the position of the original pointer.
                while nptr<n:
                    if haystack[p2] == needle[nptr]:
                        p2+=1
                        nptr+=1
                        if nptr==n:     # return the index of the beginning of the string match.
                            return p1
                    else:
                        nptr=0          # reset the pointer.
                        break
            p1+=1
        return -1


# using kmp search
# O(m+n) time | O(n) space
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        if n==0: return 0
        
        # populate the prefix location 
        # this step takes O(n) time
        ploc = [0]*n
        p1, p2 = 0, 0
        while p2<n:
            if p2==0:
                ploc[0] = 0
                p2 += 1
            elif needle[p1] == needle[p2]:
                ploc[p2] = p1 + 1
                p1 += 1
                p2 += 1
            elif p1 == 0:
                ploc[p2] = 0
                p2 += 1
            else:
                p1 = ploc[p1-1]
        
        # match the haystack and needle
        # if a match is found, return the location. else return -1
        # keep a sliding window. no need to reset the sliding window, keep moving forward based on the prefix match.
        p1, p2 = 0, 0
        m = len(haystack)
        while p1 < m:
            if haystack[p1] == needle[p2]:
                p1 += 1
                p2 += 1
            elif haystack[p1] != needle[p2] and p2!=0:
                p2 = ploc[p2-1]
            else:
                p1 += 1
                
                
            if p2 == n: # already out of the bound, so return only the pointer location minus the length of the needle.
                return p1-n
        return -1
        