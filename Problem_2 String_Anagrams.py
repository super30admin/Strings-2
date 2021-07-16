# // Time Complexity : O(m+n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# create a hashmap with count of each element in p. Then,  create a window of m length on s.
# Everytime the window is slided towards right, update current count of the incoming and outgoing letter.
# When incoming reaches 0 and outgoing 1, increment matches and when matches reaches length of counter map,
# increment result counter  to + 1. Return result counter in the end.
#
#

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        left, right = 0, 0

        hashmap = {}
        matches = 0
        result = []
        for l in p:
            if l in hashmap:
                hashmap[l] += 1
            else:
                hashmap[l] = 1

        while right < len(s):
            letter_r = s[right]
            if letter_r in hashmap:
                hashmap[letter_r] -= 1
                if hashmap[letter_r] == 0:
                    matches += 1

            if right - left + 1 > len(p):
                letter_l = s[left]
                if letter_l in hashmap:
                    hashmap[letter_l] += 1
                    if hashmap[letter_l] == 1:
                        matches -= 1
                left += 1

            if matches == len(hashmap.keys()):
                result.append(left)

            right += 1

        return result
