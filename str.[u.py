# Time Complexity :first= O(N*N),  
# Space Complexity :first= O(1), 
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



# first
class Solution:
    
    def strStr(self,haystack: str, needle: str) -> int:
        n=len(needle)
        if(n==0):
            return 0
        
        m=len(haystack)
        if(n==1):
            for k in range(m):
                if(haystack[k]==needle[0]):
                    return k
        #print("m={}, n={}".format(m,n))
        for i in range(m-n+1):
            #print("i=",i)
            for j in range(n):
                #print("inner j={}".format(j))
                if(haystack[i+j]!=needle[j]):
                    f=False
                    break
                else:
                    f=True
            if(j+1==n and f):
                return i
        return -1