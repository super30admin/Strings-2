class Solution:
    
    """
    Brute force: Time Complexity: O(mn)
                 Space complexity: O(1)
    """
    
    def strStr(self, haystack: str, needle: str) -> int:

        if len(needle) == 0: return 0
        if len(haystack) < len(needle): return -1
        start = 0

        while start < len(haystack): 
            substr = haystack[start: start+len(needle)]
            if len(substr) == len(needle) and all([i == j for i, j in zip(needle, substr)]):
                return start
                break
            start += 1

        return -1
