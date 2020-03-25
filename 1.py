# time: O(needle_len * haystack_len)
# space: O(needle_len)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        for start in range(0, len(haystack) - len(needle) + 1):
            if haystack[start: start + len(needle)] == needle:
                return start

        return -1