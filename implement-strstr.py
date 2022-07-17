# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)>len(haystack): return -1
        n=len(haystack)
        m=len(needle)
        lps=self.lps(needle)
        i=0
        j=0
        while i<n:
            if haystack[i]==needle[j]:
                i+=1
                j+=1
                if j==m:
                    return i-m
            elif haystack[i]!=needle[j] and j>0:
                j=lps[j-1]
            elif haystack[i]!=needle[j] and j==0:
                i+=1
        return -1
    def lps(self,needle:str):
        lps=[]
        lps.append(0)
        j=0
        i=1
        while i<len(needle):
            if needle[i]==needle[j]:
                j+=1
                lps.append(j)
                i+=1
            elif needle[i]!=needle[j] and j>0:
                j=lps[j-1]
            elif needle[i]!=needle[j] and j==0:
                lps.append(0)
                i+=1
        return lps
    
    
    # Time Complexity: O(n^2)
    # Space Complexity: O(1)
    # def strStr(self, haystack: str, needle: str) -> int:
    #     if len(needle)>len(haystack): return -1
    #     n=len(haystack)
    #     m=len(needle)
    #     i=0
    #     j=0
    #     while i<n:
    #         if haystack[i]==needle[j]:
    #             k=i
    #             while k<n:
    #                 if haystack[k]==needle[j]:
    #                     k+=1
    #                     j+=1
    #                     if j==m:
    #                         return i
    #                 else:
    #                     j=0
    #                     break
    #         i+=1
    #     return -1