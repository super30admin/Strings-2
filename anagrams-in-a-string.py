# Time Complexity: O(M+N) - M is len of s and N is len of p
# Space Complexity: O(N)
# Approach: Create a frequency counter for characters of the pattern. Use a window to iterate over the string. For every character, check if it matches the pattern, decrement counts in the frequency map to indicate exact matches. If the window length exceeds the length of the pattern, shrink the window by moving the start pointer and adding back the matched character frequencies to the map.
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        start = 0
        pattern_freq = collections.Counter(p)
        match = 0
        result = []
        
        for end in range(len(s)):
            end_char = s[end]
            if end_char in pattern_freq:
                pattern_freq[end_char] -= 1
                if pattern_freq[end_char] == 0:
                    # The characters in string in the window match pattern
                    match += 1
            # Window length exceeds pattern length, shrink window
            if end - start + 1 > len(p):
                start_char = s[start]
                start += 1
                if start_char in pattern_freq:
                    if pattern_freq[start_char] == 0:
                        match -= 1
                    pattern_freq[start_char] += 1
                    
            if len(pattern_freq) == match:
                result.append(start)
                
        return result