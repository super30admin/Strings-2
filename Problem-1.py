#Time Complexity :O(m+n) m is size of needle
#Space Complexity :o(m) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if(len(needle)==0 or needle==""):
            return 0
        
        lps=self.getLpsArray(needle)
        j,i=0,0
        while(i<len(haystack)):
            if(haystack[i]==needle[j]):
                i+=1
                j+=1
            elif(j>0 and haystack[i]!=needle[j]):
                j=lps[j-1]
            elif(j==0 and haystack[i]!=needle[j]):
                i+=1
            if(len(needle)==j):
                return i-j
        
        return -1
        
    def getLpsArray(self,string):
        i=1
        j=0
        lps=[None]*(len(string))
        lps[0]=0
        while(i<len(string)):
            if(string[j]==string[i]):
                j+=1
                lps[i]=j
                i+=1
            elif(j>0 and string[j]!=string[i]):
                j=lps[j-1]
            elif(j==0 and string[j]!=string[i]):
                lps[i]=0
                i+=1
                
        return lps
                