#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n=len(needle)
        j=0
        for i in range(len(haystack)):
            if haystack[i]==needle[j]:
                if haystack[i:i+n]==needle[:n]:
                    return i
        return -1
