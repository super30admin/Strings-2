# APPROACH 1: BRUTE FORCE 
# Time Complexity : O(s*p), s: len(s), p: len(p)
# Space Complexity : O(1) as p and s count arrays are of constant size 26
# Did this code successfully run on Leetcode : No (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Consider all substrings of same length of p
# 2. For each such substring, check if the count of chars is same as that of p
# 3. If equal, store the start ind

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if s is None or p is None:
            return None
        
        result = []
        for start in range(len(s) - len(p) + 1):
            for end in range(start + len(p), len(s) + 1):
                if self.isAnagram(s, p, start, end):
                    result.append(start)
                    
        return result
          
        
    def isAnagram(self, s, p, start, end):
        char_count_p = [0] * 26
        for char in p:
            char_count_p[ord(char) - ord('a')] += 1
          
        char_count_s = [0] * 26
        for ind in range(start, end):
            char_count_s[ord(s[ind]) - ord('a')] += 1
            
        if char_count_p == char_count_s:
            return True
        else:
            return False
            
   
   

# APPROACH 2: OPTIMAL APPROACH USING 2 ARRAYS
# Time Complexity : O(s + p), s: len(s), p: len(p)
# Space Complexity : O(1), as p and s count arrays are of constant size 26
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. have a char count for p using ord
# 2. we will use a fixed sliding window of size k. store the char count of all chars in this window. if char counts of s and p are same, store the start ind of the window.
# 3. If the window size exceeds, dec count of char at start of window and inc the count of char at end of window.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if s is None or p is None:
            return None
        
        char_count_p, char_count_s = [0] * 26, [0] * 26
        
        for char in p:
            char_count_p[ord(char) - ord('a')] += 1
            
        result = []   
        for ind in range(len(s)):
            char_count_s[ord(s[ind]) - ord('a')] += 1
            
            if ind >= len(p):
                char_count_s[ord(s[ind - len(p)]) - ord('a')] -= 1
                
            if char_count_p == char_count_s:
                result.append(ind - len(p) + 1)
                
        return result
        
        
 
 
# APPROACH 3: OPTIMAL APPROACH USING ONE HASHMAP
# Time Complexity : O(s + p), s: len(s), p: len(p)
# Space Complexity : O(1), as p and s count arrays are of constant size 26
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Store the count of all unique chars in p in hashmap
# 2. for each char of s, if the char exists in hashmap, dec count, if count is 0 (then equal freq of char in s and p), inc match (tracks the number of chars matched till now)
# 3. if the ind > len(p), inc char count in hashmap and if count is 1, dec match
# 4. if match is same as len(p), store the start ind (curr_ind - len(p))

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if s is None or p is None:
            return None
        
        char_count_p = defaultdict(int)
        for char in p:
            char_count_p[char] += 1
            
        result, match = [], 0
        for ind in range(len(s)):
            if s[ind] in char_count_p:
                char_count_p[s[ind]] -= 1
                if char_count_p[s[ind]] == 0:
                    match += 1
                    
            if ind >= len(p) and s[ind - len(p)] in char_count_p:
                char_count_p[s[ind - len(p)]] += 1
                if char_count_p[s[ind - len(p)]] == 1:
                    match -= 1
                    
            if match == len(char_count_p):
                result.append(ind - len(p) + 1)
                
        return result
                
            
