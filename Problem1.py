class Solution(object):
    def strStr(self, haystack, needle):
        
        if len(needle) == 0:
            return 0
        
        if needle in haystack:
            return haystack.index(needle)
            
        return -1