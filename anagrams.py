"""
Time : O(N)
Space : O(N)
Leetcode : Yes
Explanation : Use Sliding Window just like other Substring problems but this time check that counter is 0 AND
that the length of substring == length of the anagram.
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        start, end = 0, 0
        table = Counter(p)
        counter = len(table)
        result = []
        
        while end < len(s):
            
            end_char = s[end]
            end += 1            
            if end_char in table:
                table[end_char] -= 1
                if table[end_char] == 0:
                    counter -= 1
                    
            while counter == 0:
                
                if end - start == len(p):
                    result.append(start)

                start_char = s[start]
                
                if start_char in table:
                    table[start_char] += 1
                    if table[start_char] > 0:
                        counter += 1
                        
                start += 1
                
        return result