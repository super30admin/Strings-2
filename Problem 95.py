'''
leetcode : 28 - implement strstr - https://leetcode.com/problems/implement-strstr/
time complexity - O(NM)
space complexity - O(M)
first we need to create KMP array for needle and the we compare haystack and needle
'''

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        s=haystack
        p=needle
        n=len(haystack)
        m=len(needle)
        
        if m==0:return 0
        
        KMP=self.KMP(p,m)
        
        i=0
        j=0
        while i<n:
            if s[i]==p[j]:
                j=j+1
                i=i+1
            if j==m:
                return i-j
            
            elif i<n and s[i]!=p[j] and j>0:
                j=KMP[j-1]
            
            elif i<n and s[i]!=p[j] and j==0:
                i=i+1
        return -1
        
        
        
        
    def KMP(self, p,m):
        KMP=[0 for _ in range(m)]
        i=1
        j=0
        while i<m:
            #case1 when both chars are same
            if p[i]==p[j]:
                j=j+1
                KMP[i]=j
                i=i+1
            #case2 when both the chars are not equal and j>0
            elif p[i]!=p[j] and j>0:
                j=KMP[j-1]
            #case3 when both are not equal and j==0
            elif p[i]!=p[j] and j==0:
                j=KMP[j-1]
                i=i+1
        return KMP
        