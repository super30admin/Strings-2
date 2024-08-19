from typing import List

class Solution:
    """
    Time Complexity: O(M+N)
    Space Complexity: (1)
    M is the length of the string p.
    N is the length of the string s.
    """
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        
        # Frequency map of characters in p
        freq_map = {}
        for char in p:
            if char not in freq_map:
                freq_map[char] = 0
            freq_map[char] += 1
        
        result = []
        window_start = 0
        match = 0
        
        # Sliding window over s
        for window_end in range(len(s)):
            c = s[window_end]
            
            # If the character is in p, update the freq_map and match count
            if c in freq_map:
                freq_map[c] -= 1
                if freq_map[c] == 0:
                    match += 1
            
            # If window size exceeds the size of p, shrink the window
            if window_end - window_start + 1 > len(p):
                left_char = s[window_start]
                window_start += 1
                if left_char in freq_map:
                    if freq_map[left_char] == 0:
                        match -= 1
                    freq_map[left_char] += 1
            
            # If all characters match, record the start index
            if match == len(freq_map):
                result.append(window_start)
        
        return result



