"""
Approach1: create substrings of length == pattern length and then compare if they are an anagram of given pattern.
TC: to generate substring: O(m*n), sort and compare: nlog(n) (m-n). or find the prime product of the substrings and patterns
and compare. TC: O(m-n)*n or frequency map: O(m-n)*n.

Approach2: fixed length sliding window. The size of the window is the size of the pattern. There would be incoming and
outgoing characters to that window.
Define a frequency hmap for the pattern. Start the sliding window and when incoming char comes, check if it is present in
the hmap. If yes, reduce its frequency and keep track of the frequency in hmap when they become zero that it
is the anagram.
Then move the sliding window forward to process the incoming character.
TC: O(n+m) // creating hmap + traversing the word
SC: (1)// constant character
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # store the pattern in hmap
        hmap = {}
        for ch in p:
            if ch not in hmap:
                hmap[ch] = 0
            hmap[ch] += 1

        # traverse the string using the sliding window
        ismatch = 0
        ans = []
        for idx in range(len(s)):
            # how to find that ch is incoming?
            # one character is always incoming
            if s[idx] in hmap:
                inComing = s[idx]
                hmap[inComing] -= 1
                if hmap[inComing] == 0:
                    ismatch += 1

            # check if ch is outgoing charcater
            # how to find the ch is outgoing?
            # the character is always outgoing when window exceeds the leng of p
            if idx >= len(p):
                # if outgoing ch in hmap
                out_idx = idx - len(p)
                outGoing = s[out_idx]
                if outGoing in hmap:
                    # increment freq by 1
                    hmap[outGoing] += 1
                    # if freq becomes 1 only then increase ismatch, it could be -1, -2, 2 etc
                    if hmap[outGoing] == 1:
                        ismatch -= 1

            # check if the freq of all ch in hmap is zero by using match
            if ismatch == len(hmap):
                # add the string in window to ans
                ans.append(idx - len(p) + 1)

        return ans
