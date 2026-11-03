# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap and sliding window
# Initialize a HashMap with the frequency of characters in String p
# Iterate over the String s and check if the incoming charcter is in HashMap then decrement the frequency by 1
# If the frequency is 0 then increment the counter by 1
# For outgoing character check if i >= length of String p
# Check if the left character is in HashMap if it is then increment the frequency by and if frequency is 1 decrement the counter by 1 since the character is no longer in window and we are storing distinct ch in HashMap
# Increment the left pointer by 1
# If the count becomes the length of HashMap then we found the matching substring


class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        result = []
        if len(p) > len(s):
            return result
        chdict = {}
        for i in range(len(p)):
            if p[i] not in chdict:
                chdict[p[i]] = 1
            else:
                chdict[p[i]] += 1
        left = 0
        count = 0
        for i in range(len(s)):
            # for incoming character
            if s[i] in chdict:
                chdict[s[i]] -= 1
                if chdict[s[i]] == 0:
                    count += 1
            if i >= len(p):
                # for outgoing character
                if s[left] in chdict:
                    chdict[s[left]] += 1
                    if chdict[s[left]] == 1:
                        count -= 1
                left += 1
            if count == len(chdict):
                result.append(left)
        return result
            
                
            
            



        