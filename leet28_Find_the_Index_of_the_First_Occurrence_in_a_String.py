# Solution

# // Time Complexity :  KMP Algorithm O(m+n)
#                       Hashing Approach: O(m) where m is the lenght of haystack
# // Space Complexity : KMP Algorithm O(m) - for LPS Array
#                       Hashing Approach: O(1) not using any extra space
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# KPM Algorithm Approach: Need to implement KMP Algorithm to find LPS(Largest prefix suffix)

# Hashing Approach: Since data will have smaller case letters, we can assign one value for each character from 1 to 26. Then 
# just like decimal system, we should convert the needle string characters into decimal 26 so that we get a hash value.
# example: abc will be ((26^2)*1) + ((26^1)*2) + ((26^0)*3) if we assign a=1,b=2 and c=3.
# Once we get a hash value for needle, we can start creating hash value for substrings of haystack. In O(m) time complexity,
# as we keep incrementing low and high pointers of haystack and calculating hash value of each substring. The moment a substring's
# hash value matches with needle hash value we can return the low giving the start index of the substring as result.


# new implementation of KMP Algorithm
def getLps(needle,lps,n):
    lps[0] = 0

    i = 1
    j = 0
    while i<n:
        if needle[j] == needle[i]:
            j += 1
            lps[i] = j
            i += 1
        elif j > 0:
            j = lps[j-1]
        elif j == 0:
            lps[i] = j
            i += 1

def strStr(haystack, needle):
    # KMP Algorithm
    m = len(haystack)
    n = len(needle)
    lps = [0]*n

    getLps(needle,lps,n)

    i = 0
    j = 0

    while i<m and j<n:
        if needle[j] == haystack[i]:
            j += 1
            i += 1
        elif j>0:
            j = lps[j-1]
        elif j == 0:
            i += 1
    
    if j == n:
        return i-n
    else:
        return -1


    #S30
# def strStr(haystack, needle):
    # m = len(haystack)
    # n = len(needle)

    # if m<n:
    #     return -1

    # hash = 0
    # idx = n-1

    # for c in needle:
    #     hash = (26*hash) + (ord(c)-ord("a")+1)
    #     idx -= 1
    
    # low = 0
    # high = 0
    # idx = n-1

    # newHash = 0
    # while high<n:
    #     newHash = (26*newHash) + (ord(haystack[high])-ord("a")+1)
    #     idx -= 1
    #     high += 1
    
    # if newHash == hash:
    #     return low
    
    # low += 1
    # idx = n-1

    # while low<m and high<m:
    #     newHash -= (26**idx)*(ord(haystack[low-1])-ord("a")+1)
    #     newHash = 26*newHash + (ord(haystack[high])-ord("a")+1)
    #     if newHash == hash:
    #         return low
        
    #     low += 1
    #     high += 1
    
    # return -1

    # Old implementation of KMP Algorithm
    # psl = [0] * len(needle)

    # psl[0] = 0
    # j = 0
    # return_var = -1
    # for i in range(1, len(needle)):
    #     if needle[j] == needle[i]:
    #         j += 1
    #         psl[i] = j
    #     elif j == 0:
    #         psl[i] = 0
    #     else:
    #         while j != 0 and needle[j] != needle[i]:
    #             j = psl[j - 1]
    #         if needle[j] == needle[i]:
    #             psl[i] = psl[j] + 1
    #             j += 1

    # j = 0
    # counter = 0
    # for i in range(0, len(haystack)):
    #     if j >= len(needle):
    #         return -1
    #     elif haystack[i] == needle[j]:
    #         counter += 1
    #         j += 1
    #         if return_var == -1:
    #             return_var = i
    #     else:
    #         j = j - 1
    #         if j < 1:
    #             j = 0

    #         while j != 0 and needle[psl[j]] != haystack[i]:
    #             j = psl[j - 1]

    #         if needle[psl[j]] == haystack[i]:
    #             return_var = counter = j = psl[j]
    #             counter += 1
    #             return_var = i - return_var
    #             j += 1
    #         else:
    #             return_var = -1
    #             counter = 0
    #             j = 0

    #     if counter == len(needle) and return_var != -1:
    #         return return_var

    # return -1

if __name__ == "__main__":
    haystack = "sadbutsad"
    needle = "sad"
    print(strStr(haystack, needle))