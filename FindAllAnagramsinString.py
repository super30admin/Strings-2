# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap and sliding window
# Initialize a HashMap with the frequency of characters in String p
# Iterate over the String s and check if the incoming charcter is in HashMap then decrement the count by 1
# If the count is 0 then increment the match by 1
# For outgoing character check if i >= length of String p then increment the count by 1
# If the count is 1 then decrement the match by 1 since the character is no longer in window
# If the match becomes the size of HashMap then we found the matching substring


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or not p:
            return None
        dict = {}
        match = 0
        for i in range(len(p)):
            if p[i] not in dict:
                dict[p[i]] = 1
            else:
                dict[p[i]] += 1
        res = []
        for i in range(len(s)):
            # for incoming character
            if s[i] in dict:
                dict[s[i]] -= 1
                if dict[s[i]] == 0:
                    match += 1
            if i >= len(p):
                # for outgoing character
                j = i - len(p)
                if s[j] in dict:
                    dict[s[j]] += 1
                    if dict[s[j]] == 1:
                        match -= 1
            if match == len(dict):
                res.append(i - len(p) + 1)
        return res