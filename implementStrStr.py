class Solution:
    def strStr(self, hay: str, needle: str) -> int:
        if len(needle) > len(hay):
            return -1
        for idx, ch in enumerate(hay):
            if ch == needle[0]:
                if idx + len(needle) <= len(hay):
                    if hay[idx:idx+len(needle)] == needle:
                        return idx
        return -1