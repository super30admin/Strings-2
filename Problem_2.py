"""
Time Complexity : O(m+n)
Space Complexity : O(1) as only 26 max chars in dictionary
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We first put the characters of p inside a dictionary and then start traversing s. We create a sliding window 
of size of length of p. For incoming elements, if the character is inside dict, we need to reduce its counter
as it is being used and for outgoing chars, if the char is inside dict, we need to increase its count as 
it is being released. Also, for incoming chars, if count reaches 0, increase match, for outgoing, if it reaches
1, decrement match. Whenever match equals size of dict, that means we have an anagram, so put put inside
our result the value of starting character.
"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or len(s) < len(p):
            return []
        result = []
        dictt = {}
        match = 0
        l = len(p)
        for i in p:
            if i in dictt:
                dictt[i] += 1
            else:
                dictt[i] = 1
        for i in range(len(s)):
            c = s[i]
            if c in dictt:
                dictt[c] -= 1
                if dictt[c] == 0:
                    match += 1
            if i >= l:
                out = s[i-l]
                if out in dictt:
                    dictt[out] += 1
                    if dictt[out] == 1:
                        match -= 1
            if match == len(dictt):
                result.append(i-l+1)
        return result
