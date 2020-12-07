"""
Time complexity O(NM) where len of Haystack is N and len of needle is M 
 Brute force solution

"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) ==0:
            return 0
        i=0
        while(i<len(haystack)):
            if(needle[0]==haystack[i]):
                j=0
                k=i
                while(k<len(haystack) and needle[j]==haystack[k]):
                    k+=1
                    j+=1
                    if(j==len(needle)):
                        return i
            i+=1
        return -1
        