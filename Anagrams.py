# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First we count each character in p, then we slide a window over s and update their frequency.
# We use count to track how many characters have the exact matching count — it increases or decreases when frequency hits 0 or crosses zero.
# If all characters match, we add that starting index to the result.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n = len(p)
        count = 0
        res = []
        freq_map = Counter(p)

        for i in range(len(s)):
            ch = s[i]
            if ch in freq_map:
                freq = freq_map[ch]
                freq -= 1
                freq_map[ch] = freq

                if freq == 0:
                    count += 1

            if i >= n:
                ch_out = s[i-n]
                if ch_out in freq_map:
                    freq = freq_map[ch_out]
                    freq += 1
                    freq_map[ch_out] = freq

                    if freq == 1:
                        count -= 1

            if count == len(freq_map):
                res.append(i - n + 1)

        return res


        