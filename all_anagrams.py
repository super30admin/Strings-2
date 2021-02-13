# Time Complexity : O(n) where n is the length of s
# Space Complexity : O(m) where m in the length of p
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I create a map with count of each element in p. Then I create a window of m length on s. Everytime I slide the window towards right. I update current count
# of the incoming and outgoing letter. When incoming reaches 0 and outgoing 1. I increment matches and when matches reaches length of counter map I 
# increment result counter + 1. Return result counter in the end.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        left, right = 0, 0
        
        mapping = {}
        matches = 0
        result = []
        for l in p:
            if l in mapping:
                mapping[l] += 1
            else:
                mapping[l] = 1
                
        while right < len(s):
            letter_r = s[right]
            if letter_r in mapping:
                mapping[letter_r] -= 1
                if mapping[letter_r] == 0:
                    matches += 1
                
            if right - left + 1 > len(p):
                letter_l = s[left]
                if letter_l in mapping:
                    mapping[letter_l] += 1
                    if mapping[letter_l] == 1:
                        matches -= 1
                left += 1
                        
            if matches == len(mapping.keys()):
                result.append(left)
                
            right += 1
                    
        return result
