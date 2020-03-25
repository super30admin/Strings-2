# time: O(n)
# Space: O(n)
# Runs on leetcode

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        p_dict = {}
        for ele in p:
            p_dict[ele] = p_dict.get(ele, 0) + 1
        p_chars = len(p_dict)
        matched = 0

        left = 0
        ans = []
        for right in range(len(s)):
            if s[right] in p_dict:
                p_dict[s[right]] -= 1
                if p_dict[s[right]] == 0:
                    matched += 1

            while right - left + 1 > len(p):
                if s[left] in p_dict:
                    if p_dict[s[left]] == 0:
                        matched -= 1
                    p_dict[s[left]] += 1
                left += 1

            if matched == len(p_dict):
                ans.append(left)

        return ans