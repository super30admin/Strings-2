"""

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 
Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.


Time Complexity: O(n), as we traverse s once while updating frequency maps in O(1) per step.
Space Complexity: O(n) in the worst case (storing all starting indices), but O(1) if output storage is ignored.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# used a sliding window technique to maintain character counts of `p` and a window of `s` of the same length.  
# We initialize frequency maps for `p` and the first window in `s`, then slide the window across `s`, updating counts dynamically.  
# Whenever the frequency maps match, record the starting index of the anagram in `res`.  


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        if len(p) > len(s):
            return []

        scount, pcount = {}, {}

        for i in range(len(p)):
            scount[s[i]] = 1 + scount.get(s[i], 0)
            pcount[p[i]] = 1 + pcount.get(p[i], 0)

        res = [0] if scount == pcount else []
        l = 0

        for r in range(len(p), len(s)):
            scount[s[r]] = 1 + scount.get(s[r], 0)
            scount[s[l]] -= 1

            if scount[s[l]] == 0:
                scount.pop(s[l])
            l += 1
            if scount == pcount:
                res.append(l)

        return res
