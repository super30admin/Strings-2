#time: O(mn) where n=len(haystack) and  m=len(needle)
#space: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        n=len(haystack)
        m=len(needle)
        if(m==n):
            if(haystack==needle):
                return 0
        start=0
        end=start+m
        while(end<=n):
            print(haystack[start:end])
            if(haystack[start:end]==needle):
                return start
            start+=1
            end+=1
        return -1