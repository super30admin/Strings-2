# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
All the anagrams of the string are found within the larger word by using a hashmap to store the frequency of characters in p. 
Then we look at substrings in s the size of p and reduce occurences from the hashmap accordingly. If we see all the values in 
hashmap go to 0, we get a match and we save it in the result.
"""

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s == None or len(s) == 0: return []

        result = []
        hashmap = dict()
        match = 0

        for i in range(len(p)):
            c = p[i]
            if c in hashmap:
                hashmap[c] +=1
            else:
                hashmap[c] = 1

        for i in range(len(s)):
            incoming = s[i]
            if incoming in hashmap:
                hashmap[incoming] -= 1
                if hashmap[incoming] == 0:
                    match +=1
            if i >= len(p):
                outgoing = s[i - len(p)]
                if outgoing in hashmap:
                    hashmap[outgoing] += 1
                    if hashmap[outgoing] == 1:
                        match -= 1

            if match == len(hashmap):
                result.append(i - len(p) + 1)

        return result
