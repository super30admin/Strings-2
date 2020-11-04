class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        start = 0
        end = len(needle)-1
        while end <len(haystack):
            print(haystack[start:end+1])
            if haystack[start:end+1]==needle:
                return start
            end+=1
            start+=1
        return -1
