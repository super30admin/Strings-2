#Time Complexity:O(n)
#Space Complexity:O(1)

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        window=len(needle)
        start=0
        end=window-1
        while(end<=len(haystack)):
            if needle==haystack[start:end+1]:
                return start
            else:
                start=start+1
                end=end+1
        return -1