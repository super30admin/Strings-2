# Leetcode problem link : https://leetcode.com/problems/find-all-anagrams-in-a-string/
# Time Complexity:    O(m+n) 
# Space Complexity:   O(n) for hashmap
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        BAsic approach: Search for all substrings, sort it and compare with the small string (sorted again)
        Optimized approach: Create a hashmap for characters in smaller string
        Iterate through the bigger string with slow and fast pointers
        Fast pointers keeps on checking the values in hashmap for incoming characters and decreases the count of corresponding character in hashmap. As soon as the count becomes 0 then the criteria for that character to be present has been satisfied (in case of multiple occurrences of same character).
        An integer match ill keep track of how many characters have satisfied the criteria ( instead of length)
        As soon as any character's count reaches 0 we increment match variable.
        
        When the substring under consideration crosses the length of smaller string then we need to increment start pointer. If the character at outgoing start exists in hashmap we need to increment it back as it is moving out of the window. If it has reached 1, then match is decremented by 1 as its not a valid anymore.
        When match is equal to p's legth then the current start is a valid index and add to output
'''  
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_map = {}
        output = []
        for c in p:
            if c in p_map:
                p_map[c] += 1
            else:
                p_map[c] = 1
        start = 0
        end = 0
        match = 0
        while end < len(s):
            #incoming
            if s[end] in p_map:
                p_map[s[end]] -= 1
                if p_map[s[end]] == 0:
                    match += 1
            #outgoing
            if end - start + 1 > len(p):
                if s[start] in p_map:
                    p_map[s[start]] += 1
                
                    if p_map[s[start]] == 1:
                        match -= 1
                start += 1
            if match == len(p_map):
                output.append(start)
            end += 1
        
        return output