"""
KMP algorithm 
TC=O(N+M)
SC=0(M) If M is length of the needle (LPS array)

"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(len(needle)==0):
            return 0
        m=len(haystack)
        n=len(needle)
        if(m<n):
            return -1
        lps=self.findlps(needle)
        j=0
        i=0
        while(i<m):
            if(haystack[i]==needle[j]):
                i+=1
                j+=1
                if(j==n):
                    return i-n
            elif(i<m and j>0 and haystack[i]!=needle[j] ):
                j=lps[j-1]
            elif(j==0 and haystack[i]!=needle[j]):
                i+=1
        return -1
            
    
    def findlps(self,needle):
        lps=[0]*len(needle)
        j=0
        i=1
        while(i<len(needle)):
            if(needle[i]==needle[j]):
                j+=1
                lps[i]=j
                i+=1
            elif(j>0 and needle[i]!=needle[j]):
                j=lps[j-1]
            elif(j==0 and needle[i]!=needle[j]):
                lps[i]=0
                i+=1
        return lps
                
                
        
        
        
        
        
        
        
        