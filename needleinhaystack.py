"""https://leetcode.com/problems/implement-strstr/"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needlelength=len(needle)
        haystacklength=len(haystack)
        if needlelength==0:
            return 0
        else:
            for i in range(haystacklength - needlelength+1):
                if haystack[i]!=needle[0]:
                    continue
                if haystack[i:i+needlelength]==needle:
                    return i
            return -1



