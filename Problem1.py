# Time Complexity: O (n*m)(Where n is length of haystack and m is length of needle)
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode : No (Time Limit Exceeds)
# Three line explanation of solution in plain english:
# - Comparing needle considering every charcater as starting point for needle.

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        # BruteForce Solution
        if not needle:
            return 0
        if len(needle) > len(haystack):
            return -1
        occur = -1
        for hayindex in range(len(haystack)):
            if haystack[hayindex] == needle[0]:
                i = hayindex
                for j in range(len(needle)):
                    if i < len(haystack) and haystack[i] == needle[j]:
                        i += 1
                        if j == len(needle) - 1:
                            return hayindex
                    else:
                        break
        return -1
