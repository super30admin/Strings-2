# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        len_p = len(p)
        len_s = len(s)
        if len_p > len_s:
            return res
        p_count = Counter(p)
        s_count = Counter(s[:len_p])
        if s_count == p_count:
            res.append(0)
        for i in range(1, len_s - len_p + 1):
            s_count[s[i - 1]] -= 1
            if s_count[s[i - 1]] == 0:
                del s_count[s[i - 1]]
            s_count[s[i + len_p - 1]] += 1
            if s_count == p_count:
                res.append(i)
        return res
        