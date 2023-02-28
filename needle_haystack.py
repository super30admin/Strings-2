# Time Complexity :
# O(NM)  - Size of the needle * size of the haystack

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We store a needle index to 0
#We go through each character of the haystack and check if it's character is same as the character in needle. If it is, we go ahead to next character in both, if it's not, we set the needle index to 0 and haystack index to where the needle started matching
#We do this until haystack index reaches the end and if anywhere on the way, needle index reaches its end, we return the needle start index

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        if len(haystack) == 0 or len(needle) == 0:
            return -1
        j = 0
        needle_found_start = -1
        i= 0
        #for i,char in enumerate(haystack):
        while i in range(len(haystack)):
            char = haystack[i]
            if char == needle[j] :
                if j == 0 :
                    needle_found_start = i
                j += 1
            else :
                if needle_found_start != -1 :
                    i = needle_found_start
                needle_found_start = -1
                j = 0

            if j == len(needle):
                return needle_found_start

            i += 1

        return -1
