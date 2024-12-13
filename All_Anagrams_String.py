# Approach:
# To find all the start indices of anagrams of `p` in `s`, we can use the sliding window technique.
# We slide a window of size equal to the length of `p` across `s`. In each window, we check if the substring
# is an anagram of `p`. An anagram is simply a rearrangement of the characters in `p`, meaning both `p` and
# the current window should have the same character counts for every character.
# We can use two frequency count arrays (one for `p` and one for the current window in `s`) and compare them.
# If they match, it means the current window is an anagram of `p`.

# Time Complexity: O(n), where n is the length of the string `s`. We use a sliding window of size `m` (length of `p`) 
# and move the window across `s` in O(1) time for each character.
# Space Complexity: O(1), since we are using fixed-size arrays (26 for lowercase letters), regardless of the size of `s` and `p`.
# Did this code successfully run on Leetcode: Yes, the code works correctly and passes all test cases on Leetcode.
# Any problem you faced while coding this: No major issues. Just ensuring efficient sliding window implementation.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # If s is shorter than p, there can't be any anagrams, so return an empty list.
        if len(s) < len(p):
            return []

        # Initialize character counts for p and the sliding window in s.
        p_count = [0] * 26  # count of characters in p
        window_count = [0] * 26  # count of characters in the current window of s
        result = []

        # Populate the character count for p.
        for char in p:
            p_count[ord(char) - ord('a')] += 1
        
        # Start sliding window over s.
        for i in range(len(s)):
            # Add current character to the window's character count.
            window_count[ord(s[i]) - ord('a')] += 1

            # When the window size is greater than or equal to the size of p, we check if it's an anagram.
            if i >= len(p):
                # If window size exceeds p's size, remove the leftmost character from the window.
                window_count[ord(s[i - len(p)]) - ord('a')] -= 1

            # If the window matches the character count of p, it's an anagram.
            if window_count == p_count:
                result.append(i - len(p) + 1)

        return result
