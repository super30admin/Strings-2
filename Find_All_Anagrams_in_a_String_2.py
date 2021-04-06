# Created by Aashish Adhikari at 11:49 PM 3/24/2021

'''
Time Limit exceeds.

Time Complexity:
O(m.n.logn)

Space Complexity:
O(m.n)
'''

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        # sort p
        p = sorted(p) # cannot call in-place sorting method on immutable data type.
        sol = []

        for idx in range(0, len(s)-len(p) + 1):

            sorted_substring = sorted(s[idx:idx+len(p)]) # out-of-place sorting

            if sorted_substring == p:
                sol.append(idx)

        return sol




