#Time Complexity :O(m+n)
#Space Complexity :O(1) 26 char
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m=len(haystack)
        n=len(needle)
        HashNeedle=0
        hashCurr=0
        
        if m<n:
            return -1
        for i in range(n):
            c=needle[i]
            HashNeedle=HashNeedle*10+(ord(c)-ord('a')+1)

        nl=pow(10,n)
        for i in range(m):
            #in
            inChar=haystack[i]
            hashCurr=hashCurr*10+(ord(inChar)-ord('a')+1)
            #out
            if i>=n:
                out=haystack[i-n]
                hashCurr=hashCurr-(nl*(ord(out)-ord('a')+1))

            if hashCurr==HashNeedle:
                return i-n+1

        return -1



