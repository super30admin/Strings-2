# Leetcode excution: YES
# time complexity: O(n)
# space complexity: O(len(needle))
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0: return 0
        
        # loop though the haystack do sliding window for fixed size every loop. we start from i and get string till len(needle)
        # as son as we find the matching string we retun index i else return -1 finally and if i reached a place whre we can no loger get substring of needle length then we return -1
        
        for i in range(len(haystack)):
            if len(haystack)-i<len(needle):
                return -1
            substr=haystack[i:i+len(needle)]
            if substr==needle:
                return i
            
        return -1
                    
        