"""
// Time Complexity : O(Ns + Np)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

from collections import Counter,defaultdict
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        Brute force
        - Scan p across the s for each start character in s in O(m * n)
        
        Optimal idea - Sliding window
        Idea is to use a map of count of chars in p and map of count of chars in s(for all 26 chars) and 
        update it by sliding the window in s using start and end pointer based on the current length in s
        If the length matches the length of p, check if chars match to fulfill the anagram property in window and add the start index to the result
        
        If the current length is less than p's length, expand the window by incrementing end and adding char's count to map
        
        If the current length is more than p's length, create a new window by incrementing start and decrementing char's count from the map
        """
        
        char_count = Counter(p)
        
        s_count = [0]*26
        char_count = [0]*26
        
        for i in p:
            char_count[ord(i)-ord('a')]+=1
        
        start,end = 0,0
        result = []
        if not p:
            return []
        while end < len(s):
            char_s = ord(s[start]) - ord('a')
            char_e = ord(s[end]) - ord('a')

            current_length = end - start + 1
            if current_length < len(p): #expand the window by updating end
                #add the last char pointing end in s from the window
                s_count[char_e]+=1
                end+=1
            elif current_length == len(p):
                s_count[char_e]+=1
                
                #check for valid anagram
                if s_count == char_count:
                    result.append(start)
                end+=1

            elif current_length > len(p):
                #removing the last char pointing to start in s from the window
                s_count[char_s]-=1
                start+=1
        
        return result