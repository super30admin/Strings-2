# Problem2: Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)
# Time Complexity: O(m + n),We spend O(n) time building the frequency map from p once.Then we spend O(m) time sliding through s, doing constant work at each step.So total work grows in a straight line with the sizes of s and p, not multiplied together.
# Space Complexity: O(1),The map can only ever hold lowercase english letters, so it never grows past 26 keys.
# Approach:
# First we count how many times each letter appears in p and store it in a map.
# Then we slide a window of size n across s, one character at a time.
# As a character enters the window we reduce its count and as a character leaves the window we increase its count back.
# We track how many letters are currently perfectly balanced using match.
# When match equals the number of distinct letters in p, the current window is an anagram of p, so we save its start index.class Solution:
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []             # this will store all starting indices where an anagram of p is found
        m = len(s)              # total length of s, used to control how far the main loop runs
        n = len(p)              # length of p, this is also the fixed size of our sliding window

        map = {}                   # this will hold how many of each letter p needs
        for c in p:
            if c in map:
                map[c] += 1         
            else:
                map[c] = 1          

        match = 0             # counts how many letters currently have the exact count needed, meaning they are balanced

        for i in range(m):    # i moves across every position in s, acting as the right edge of the window
            in_char = s[i]      # the character that is entering the window right now
            if in_char in map:
                frequency = map[in_char]
                frequency -= 1              # we are using up one occurrence of this letter inside the window
                map[in_char] = frequency    # save the updated count back into the map
                if frequency == 0:
                    match += 1              # this letter just became perfectly balanced, so count it

            if i >= n:             # this means the window has reached its full size, so we must drop the leftmost character
                out_char = s[i - n]      # this is the character leaving the window on the left side
                if out_char in map:
                    frequency = map[out_char]
                    frequency += 1           # we are giving back one occurrence since this letter is leaving the window
                    map[out_char] = frequency  # save the updated count back into the map
                    if frequency == 1:
                        match -= 1              # this letter is no longer balanced, so we remove it from the count

            if match == len(map):   # if every distinct letter in p is currently balanced, the window is an anagram
                result.append(i - n + 1)  # i minus n plus one gives the starting index of this window

        return result
