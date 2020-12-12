# Time Complexity:- O(m+n)
# Space Complexity:- O(n) n=length of the needle
# Approach:- Build the longest prefix-suffix array and then use that array for going back to check 
# if the haystack and needle charachters match or not.
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        def lps(needle):
            lpsarr=[0]*len(needle)
            j=0
            i=1
            while(i<len(needle)):
                if(needle[i]==needle[j]):
                    j+=1
                    lpsarr[i]=j
                    i+=1
                elif needle[i]!=needle[j] and j>0:
                    j=lpsarr[j-1]
                else:
                    lpsarr[i]=0
                    i+=1
            return lpsarr
        if len(needle)==0:
            return 0
        m=len(haystack)
        n=len(needle)
        i,j=0,0
        lps=lps(needle)
        if(m<n):
            return -1
        while(i<m):
            if haystack[i]==needle[j]:
                i+=1
                j+=1
                if j==n:
                    return i-n
            elif i<m and j>0 and haystack[i]!=needle[j]:
                j=lps[j-1]
            elif i<m and j==0 and haystack[i]!=needle[j]:
                i+=1
        return -1
                
                
            