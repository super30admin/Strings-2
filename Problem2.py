# Time Complexity: O (s)(Where s is length string)
# Space Complexity: O(1) (Constant time because all the characters are lower case)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use sliding window with counter. Add p into the counter. Store length of S as remaining.
# - Move the right side, and if right element is in the counter reduce it's count and reduce remaining. Append the answer if remaining becomes 0.
# - If left element is in the counter increase it's count and increase remaining. Move left side when window size is same as S. 


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        data = {}
        ans = []
        
#       Store p's character count in data.
        for char in p:
            data[char] = data.get(char, 0) + 1
            
#       Initialize left, right and counter as length of p.
        left = 0
        right = 0
        remaining = len(p)
        
#       Run until right reach ends
        while right < len(s):
#           If right is in the data than reduce it's count and reduce remaining
            if s[right] in data:
                data[s[right]] -= 1
                if data[s[right]] >= 0:
                    remaining -= 1
#           Increment right everytime
            right += 1
            
#           If remaining reach zero means we found every charcter of p in S. Insert starting index left into the answer.
            if remaining == 0:
                ans.append(left)
                
#           If window size is equal to length of anagram, move left.
            if right - left == len(p):
#           If left is in the data than incraese it's count and increase remaining because we are discarding left.
                if s[left] in data:
                    if data[s[left]] >= 0:
                        remaining += 1
                    data[s[left]] += 1      
                left += 1
                
        return ans
    
    
