#Time complexity is: O(m+n) where m is the length of haystack and n is the length of the needle
#Space complexity is: O(1)
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        #initializing the required variables
        m=len(haystack)
        n=len(needle)
        k=26
        #taking the initial values of needleHash and currHash as 0
        needleHash=0
        if(m<n):
            return -1
        #Calculating the needleHash value
        for i in range(n):
            c=needle[i]
            needleHash=needleHash*k + (ord(c)-ord('a')+1)
        currHash=0
        #calculating the currHash value
        for i in range(len(haystack)):
            #incoming value
            inc=haystack[i]
            #calculating the currHashvalue
            currHash=currHash*k + (ord(inc)-ord('a')+1)
            #outgoing value
            if(i>=n):
                #outgoing element value
                out=haystack[i-n]
                #calculating the currHashvalue
                currHash=currHash-(ord(out)-ord('a')+1)*k**n
            #if both hashvalues matches, we are erturning the position
            if(currHash==needleHash):
                return i-n+1
        #If position not found we return -1
        return -1    