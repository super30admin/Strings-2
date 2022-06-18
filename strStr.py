# TC - O(n)
# SC - O(1)
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle:
            return 0

        if len(needle) > len(haystack):
            return -1

        i = 0

        while i < len(haystack):

            if needle[0] == haystack[i]:
                if haystack[i:i + len(needle)] == needle:
                    return i
            i += 1

        return -1
