class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0:
            return 0
        m=len(haystack)
        n=len(needle)
        i=0
        j=0
        lps=[]
        lps=self.lps(needle)
        while i<m:
            if haystack[i]==needle[j]:
                i+=1
                j+=1
            if j==n:
                return i-n
            if i<m and j>0 and haystack[i]!=needle[j]:
                j=lps[j-1]
            elif i<m and j==0 and haystack[i]!=needle[j]:
                i+=1
    def lps(self,needle):
        lps=[None]*len(needle)
        lps[0]=0
        j=0
        i=1
        while i<len(needle):
            #case1
            if needle[i]==needle[j]:
                j+=1
                lps[i]=j
                i+=1
            elif j>0 and needle[j]!=needle[i]:
                j=lps[j-1]
            elif j==0 and needle[j]!=needle[i]:
                lps[i]=0
                i+=1
        return lps
    
        
  #time complexity is O(n)
  #space is O(1)
