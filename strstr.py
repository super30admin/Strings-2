#Time Complexity: O(n)
#Space Complexity: O(1)
#Did it run on leetcode: Yes

def strStr(self, haystack: str, needle: str) -> int:
    needle_len = len(needle)
    for i in range(len(haystack)):
        if haystack[i:i+needle_len] == needle:
            return i
    return -1