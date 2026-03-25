# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Use a hashmap to store frequency of characters in p.
# Maintain a sliding window of size len(p) over string s.
# For each incoming character, decrease its count in hashmap.
# If count becomes 0, increment freq.
# When window exceeds size, remove outgoing character and update freq accordingly.
# If freq equals number of unique characters in hashmap, we found an anagram.


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        cnt_mp = {}
        for i in p:
            if i in cnt_mp:
                cnt_mp[i] += 1
            else:
                cnt_mp[i] = 1
        freq = 0
        res = []
        n = len(p) 
        for i in range(len(s)):
            if s[i] in cnt_mp:
                cnt_mp[s[i]] -= 1
                if cnt_mp[s[i]] == 0:
                    freq += 1
            
            if i >= n:
                idx = i - n 
                if s[idx] in cnt_mp:
                    cnt_mp[s[idx]] += 1
                    if cnt_mp[s[idx]] == 1:
                        freq -= 1
            print(freq)
            if freq == len(cnt_mp):
                res.append((i - n + 1))

        return res

