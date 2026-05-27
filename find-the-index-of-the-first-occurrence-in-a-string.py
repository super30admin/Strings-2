# Time Complexity: O(m+n) 
# Space Complexity: O(1)   
# Did this code successfully run on Leetcode: Yes

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        phash=0
        shash=0
        plen=len(needle)
        slen=len(haystack)
        kl=26**(plen-1)

        for i in needle:
            phash=phash*26 + (ord(i) - ord('a') +1)
        

        for i in range(slen):
            #out
            if i>=plen:
                out=haystack[i-plen]
                shash=shash - ((ord(out) - ord('a') +1) * kl)
            
            #in
            invalue=haystack[i]
            shash=shash*26 + (ord(invalue) - ord('a') +1)

            if shash==phash:
                return i-plen+1
        
        return -1
            