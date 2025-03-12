# Time Complexity : O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        m = len(s)
        n = len(p)
        p_map = {}
        match_count = 0
        result = []

        for i in range(0,n):
            if p[i] in p_map:
                p_map[p[i]] += 1
            else:
                p_map[p[i]] = 1

        for i in range(0,m):
            ch = s[i]

            if ch in p_map:
                p_map[ch] -= 1
                if p_map[ch] == 0:
                   match_count += 1

            if i >= n:
                if s[i-n] in p_map:
                    p_map[s[i-n]] += 1
                    if p_map[s[i-n]] == 1:
                        match_count -= 1

            if match_count == len(p_map):
                result.append(i-n+1)
        return result