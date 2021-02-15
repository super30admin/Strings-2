# T = O(mn)
# S = O(1)

# Approach:
# Brute Force:
# Iterate through every element in the haystack and check if the first character of the needle and haystack match
# if so then check if the lenght of the needle from that pointer on the haystack match the entire needle and return the index
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        if len(haystack) >= len(needle):
            for c in range(len(haystack)):
                if haystack[c] == needle[0] :
                    if haystack[c:c+len(needle)] == needle:
                        return c
        return -1
		
# T = O(m+n)
# S = O(n)

# Approach:
# KMP algorithm, I havent understood the entire algo just implemneted the code seeing the videos
# I will update the approach later.
# I am not sure why leetcode solution for this method was slower than the previous one.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        i , j = 0 , 0
        needlelps = self.lpsbuilder(needle)
        
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - j
            elif j > 0 and haystack[i] != needle[j]:
                j = needlelps[j-1]
            elif j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1
                
    def lpsbuilder(self,array):
        lps = [0] * len(array)
        lps[0] = 0
        i = 1
        j = 0
        while i < len(array):
            ## case1 if both elements are equal
            if array[i] == array[j]:
                j += 1
                lps[i] = j
                i += 1
            ## case2 if both elements are not equal
            elif array[i] != array[j] and j > 0 :
                j = lps[j-1]
            elif  j == 0 and array[i] != array[j]:
                lps[i] = 0
                i += 1
        return lps
                