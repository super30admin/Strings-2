# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        sdict, pdict = {}, {}
        left = 0

        for char in p:
            pdict[char] = pdict.get(char, 0) + 1

        for i in range(len(s)):
            sdict[s[i]] = sdict.get(s[i], 0) + 1

            if (i - left + 1) == len(p):

                if sdict == pdict:
                    res.append(left)

                sdict[s[left]] -= 1
                if sdict[s[left]] == 0:
                    del sdict[s[left]]
                left += 1

        return res
