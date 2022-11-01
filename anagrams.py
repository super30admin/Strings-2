"""
Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)
Approach --
1. Use hmap to store p string chars. And their occurrences in p string as value
2. Use slow pointer at idx 0. If the char in hmap, increment fast pointer.
While traversing s, incerment the fast pointer, every time a char from hmap is found, decrement it's value from hmap
3. Maintain a match variable to keep track of the length of the anagram being formed. Increment char every time a chars
value in hamap becomes 0
4. if a character in 's' is found which is not in p, move the slow pointer by 1 and increment the value of that char in
hmap
This indicates, to form the next anagram, this curr outgoing char is required
5. For outgoing chars, decrement the count of char when count == 1

TC - O(m+n) - m = len(s), n = len(p)
SC - o(1) -- since 26 chars
"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s is None or len(s) == 0 or p is None or len(p) > len(s): return []

        hmap = {}
        match = 0
        rtnData = []

        for i in range(len(p)):
            c = p[i]
            hmap[c] = 1 + hmap.get(p[i], 0)

        # iterate to check incoming and outgoing characters
        for j in range(len(s)):
            # incoming
            if s[j] in hmap:
                # get the val and reduce it to 1
                count = hmap[s[j]]
                count -= 1
                hmap[s[j]] = count

                if count == 0:
                    match += 1
            # outgoing char
            if j >= len(p):
                # get the last/outgoing character
                out = j - len(p)
                if s[out] in hmap:
                    count = hmap[s[out]]
                    count += 1
                    hmap[s[out]] = count

                    if count == 1:
                        match -= 1
            if match == len(hmap):
                rtnData.append(j - len(p) + 1)
        return rtnData
