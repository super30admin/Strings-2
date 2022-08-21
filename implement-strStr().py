"""
Runtime Complexity:
O(n*m) - let 'n' and 'm' be the length haystack and needle respectively. We go through all the elements to check whether the substring 
match.
Space Complexity: O(1)- no extra space was used to compute the solution.
Yes, the code worked on leetcode
Issus while coding- No
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        for i in range(len(haystack)+1-len(needle)):
            if haystack[i:i+len(needle)] == needle:
                return  i
        return -1
        
            
        