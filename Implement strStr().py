""""// Time Complexity : O(m) m -> Length of haystack string
// Space Complexity : O(n) n -> length of needle string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m=len(haystack)
        n=len(needle)
        if n==0:
            return 0
        if m < n:
            return -1
        lps=self.commonprefix(needle)
        # print(lps)
        i=0
        j=0
        while(i<m):
            # print(j)
            if haystack[i]==needle[j]:
                i+=1
                j+=1
                if j==n:
                    return i-n
            else:
                if j>0:
                    j=lps[j-1]
                elif j==0:
                    i=i+1
            # print(i,j)
            # print(haystack[i],needle[j])
        return -1



    def commonprefix(self,needle):
        lps=[0 for i in range(len(needle))]
        i=1
        j=0
        while i<len(needle):
            if needle[i]==needle[j]:
                j=j+1
                lps[i]=j
                i=i+1
            else:
                if j>0:
                    j=lps[j-1]
                elif j==0:

                    lps[i]=0
                    i=i+1

        return lps


# BruteForce
# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         m=len(haystack)
#         n=len(needle)

#         j=0
#         for i in range(m-n+1):
#             p=i
#             while j<=n:
#                 if j==n:
#                     return i
#                 if haystack[p]==needle[j]:
#                     p+=1
#                     j+=1
#                 elif haystack[p]!=needle[j]:
#                     j=0
#                     break
#         return -1


# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         if needle == "":
#             return 0
#         for i in range(len(haystack) +1 - len(needle)):
#             if haystack[i:i+len(needle)] == needle:
#                 return i

#         return -1



