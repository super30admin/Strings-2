# Time Complexity : Add - O(2n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Sliding window using slow and fast pointers

2. Maintain 2 counter array of length 26 for a string and pattern.
3. The counter will store the fequencies of any letter indexed at ascii value
4. Now we move acrros the string, updating string counter, when the length of window == len(pattern)
5. We check if strin counter array == patterm=n counter array, if yes, append left index of window in result
6. We now move left by1, and right by one, but before that we undo the changes by decrementing count value
   at repective ascii 
'''

class Solution:
       
    def compare_arrays(self, arr1, arr2):
        
        for i in range(26):
            if arr1[i] != arr2[i]:
                return False
            
        return True
        
        
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if s == "":
            return 
        
        string_count = [0]*26
        pattern_count = [0]*26
        
        for ch in p:
            pattern_count[ord(ch)-ord('a')] += 1
            
            
        result = []
        left, right = 0, 0
        
        while right < len(s):
            
            string_count[ord(s[right]) - ord('a')] += 1
            
            if right-left+1 == len(p):
                #compare array                
                if self.compare_arrays(string_count, pattern_count):
                    result.append(left)
                
                string_count[ord(s[left]) - ord('a')] -= 1
                left +=1  
            
            right += 1
        return result
        