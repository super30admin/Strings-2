'''
haystack = "sadbutsad", needle = "sad"    

if we get 1st char same then we check for all the remaining char, and if all are same meaning j == len(needle) then just return i

TC: O(n) #because if we don't find all matching then we skip i to k-1
SC: O(1)

'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        i = 0
        for i in range((len(haystack) - len(needle) + 1)):
            if haystack[i] == needle[0]:
                j = 0
                k = i 
                while (j<len(needle) and k < len(haystack)) and (haystack[k] == needle[j]):
                    k+=1
                    j+=1
                if j == len(needle):
                    return i
                i = k-1
        return -1