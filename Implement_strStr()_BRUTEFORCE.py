# Created by Aashish Adhikari at 4:11 PM 2/13/2021

'''
Time Complexity:
O(n.l) , can be made a little faster to O((n-l).l) by iterating only n-l times.

Space ComplexitY:
O(1)
'''

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """


        if needle == "":
            return 0


        leng = len(needle)
        for idx in range(len(haystack)):

            end = idx + leng - 1
            if end > len(haystack):
                pass
            else:
                if haystack[idx:end+1]== needle:
                    return idx

        return -1



