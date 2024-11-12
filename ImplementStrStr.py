#Time Complexity: O((n−m)⋅m)
#Space Complexity: O(1) 
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(len(needle)==0):
            return 0
        for i in range(0, len(haystack)):
            if(haystack[i:i+len(needle)]==needle):
                return i
            else:
                continue
        return -1
