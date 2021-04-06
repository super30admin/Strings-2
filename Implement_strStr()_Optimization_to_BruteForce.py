# Created by Aashish Adhikari at 2:18 PM 3/18/2021

'''
Time Complexity:
O(m . n)

Space Complexity:
O(1)
'''


class Solution(object):


    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        m, n = len(haystack), len(needle)

        start = 0



        while start < m - n+1:
            slicee = haystack[start:start+n]
            if slicee == needle:
                return start

            start += 1

        return -1
