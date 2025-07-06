"""
TC:O(m+n)
SC: O(1)

"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        hay_ptr = 0
        needle_ptr = 0
        start = -1
        while(hay_ptr<len(haystack) and needle_ptr<len(needle)):
            if haystack[hay_ptr]==needle[needle_ptr]:
                if start == -1:
                    start = hay_ptr
                hay_ptr+=1
                needle_ptr+=1
            else:
                start=-1
                hay_ptr = hay_ptr-needle_ptr+1
                needle_ptr=0
        return start if needle_ptr==len(needle) else -1