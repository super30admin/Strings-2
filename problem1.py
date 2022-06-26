class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n= len(needle)
        
        for i,v in enumerate(haystack):
            if(v==needle[0]):
                ptr1 = i
                ptr2 = 0
                while(ptr1<m and ptr2<n):
                    if(haystack[ptr1]!=needle[ptr2]):
                        break
                    ptr1+=1
                    ptr2+=1
                if(ptr2==n):
                    return i
        return -1