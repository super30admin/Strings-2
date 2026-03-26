# https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
# Any problem you faced while coding this : no

# Implementing this with sliding window approach. Using hashmap to store the frequency of each character in p. 
# Then we traverse s linearly, to check if we have found a matching character in hm. If so, we decrement the hashmap
# freq count for that char. If freq becomes zero for that char, then we have found a match for that char, we increment match
# If i index becomes more than n (which is length of p), then we have to start kicking out one character at a time, to keep the
# length of the substring we are checking in s is same as p's length. If the out char is in hm, then increment the freq for that char
# because we need to give that back as we are not including in our current substring. If freq count for that char is 1, then we
# decrement match, because now we have lost a matched char while we kicked out a char. In the end, we check if match is equal to
# length of hm. If so we add the starting index of matched substring to res []. Then return the result.

# TC: O(m+n)
# SC: O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        match = 0
        hm = {}
        n = len(p)

        for i in p:
            if i not in hm:
                hm[i] = 1
            else:
                hm[i] += 1

        for i in range(len(s)):
            if i >= n:
                out = s[i-n]

                if out in hm:
                    hm[out] += 1
                    if hm[out] == 1:
                        match -= 1

            if s[i] in hm:
                hm[s[i]] -= 1
                if hm[s[i]] == 0:
                    match += 1

            if match == len(hm):
                res.append(i-n+1)

        return res