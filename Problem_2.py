# Time Complexity: O(n)
# Space Complexity: O(26)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        c = collections.Counter(p)
        cur = collections.Counter(s[:len(p)])
        for i in range((len(s) - len(p) + 1)):
            if cur == c:
                res.append(i)
            if i == (len(s) - len(p)):
                break
            cur[s[i]] -= 1
            if cur[s[i]] == 0:
                del cur[s[i]]
            cur[s[(i + len(p))]] += 1
        return res