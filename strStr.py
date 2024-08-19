class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Edge case: if needle is an empty string, return 0
        if len(needle) == 0:
            return 0
        
        # Lengths of haystack and needle
        n, m = len(haystack), len(needle)
        # Iterate over haystack to find the first occurrence of needle
        for i in range(n - m + 1):
            # Check if the substring of haystack matches needle
            if haystack[i:i + m] == needle:
                return i
        
        # If no match found, return -1
        return -1
        
