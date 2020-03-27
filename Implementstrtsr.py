// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we use kmp algorithm on this problem.For this we have two stages one for creating pi array which contains the count of proper prefix and suffix and the created pi array will be used in pattern matching.

# KMP algorithm
# Time complexity --> o(m+n) m=len(haystack),n=len(needle)
# space complexity --> o(n) n=len(needle)
class Solution(object):
    def computepi(self,needle):
        j=0
        i=1
        pi=[0 for i in range(len(needle))]
        while i<len(needle):
            if needle[i]==needle[j]:
                j=j+1
                pi[i]=j
                i=i+1
            else:
                if j==0:
                    pi[i]=0
                    i=i+1
                else:
                    j=pi[j-1]
        return pi
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        
        if len(needle)==0:
            return 0
        pi=self.computepi(needle)
        i=0
        j=0
        while i<len(haystack):
            if haystack[i]==needle[j]:
                i=i+1
                j=j+1
                if j==len(needle):
                    return i-j
            else:
                if j==0:
                    i=i+1
                else:
                    j=pi[j-1]
        return -1
        
        
        
                