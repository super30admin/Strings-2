# Time Complexity : O(n)
# Space Complexity : O(1) for the dictionary
# The code ran on LeetCode

# Maintain a hashmap to store the count of all letters in the pattern. Move a sliding window over the input string, find the index where the frequency of each character in the window and pattern match. 

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d = {}; n = len(p)
        for i in range(len(p)):
            d[p[i]] = d.get(p[i], 0) + 1
        match = 0; target = len(d.keys())
        res = []
        for i in range(len(s)):
            cur = s[i]

            if i < n:
                if cur in d:
                    d[cur] -= 1
                    if d[cur] == 0:
                        match += 1
            else:
                incoming = cur
                outgoing = s[i-n]

                if incoming in d:
                    d[incoming] -= 1
                    if d[incoming] == 0:match+=1
                if outgoing in d:
                    d[outgoing] += 1
                    if d[outgoing] == 1:
                        match -= 1
            if match == target:
                res.append(i - n + 1)
        return res