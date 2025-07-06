# TC: O(n + m)
# SC: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # needle value 
        nv=0
        for i in needle:
            nv=26*nv+(ord(i)-ord('a')+1)
        
        i=0
        cv=0
        while i<len(haystack):
            cv=cv*26+(ord(haystack[i])-ord('a')+1)
            if i>=len(needle):
                prev=i-len(needle)
                cv=cv-( 26**(len(needle))*(ord(haystack[prev])-ord('a')+1) )
            
            if cv==nv:
                return i-len(needle)+1
            
            i+=1
        
        return -1
