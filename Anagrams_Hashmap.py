# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pattern = {}
        n = len(s)
        res = []
        
        # make the frequency count of the pattern string
        for i in range(len(p)):
            ch = p[i]
            if ch in pattern:
                pattern[ch] += 1
            else:
                pattern[ch] = 1
        
        match = 0
        
        # traverse over the s string to check for possible matches
        for i in range(n):
            # incoming character
            # for the incoming character, we decrement the count from freq map and increment the match count if freq is 0
            inc = s[i]
            if inc in pattern:
                pattern[inc] -= 1
                if pattern[inc] == 0:
                    match += 1
            
            # outgoing character
            # for outgoing character, we restore the freq in map and reduce the match count only if the count becomes 1
            if i >= len(p):
                outc = s[i - len(p)]
                if outc in pattern:
                    pattern[outc] += 1
                    if pattern[outc] == 1:
                        match -= 1
            
            # append the starting index to res only if the match count equals the size of Hashmap
            if match == len(pattern):
                res.append(i - len(p) + 1)
        
        return res
