"""
Leetcode: https://leetcode.com/problems/find-all-anagrams-in-a-string/

Basic approach: Search for all substrings, sort it and compare with the small string (sorted again)

Optimized approach: Using hashmap and two pointers, explained in the comments
Time Complexity: O(m+n) , m and n. is the length of string s and p respectively
Space Complexity: O(n) for hashmap
"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # hashmap to store chars of p string and its count as values
        p_map = {}
        # output to store start indices of p's anagrams in s
        output = []

        # Create a hashmap for characters in smaller string 'p'
        for char in p:
            if char in p_map:
                p_map[char] += 1
            else:
                p_map[char] = 1

        start = 0
        end = 0
        match = 0

        # iterate through string s with start and end pointer
        while end < len(s):
            # End pointer keeps on checking the values in hashmap for incoming characters and decreases the count
            # of corresponding character in hashmap.
            if s[end] in p_map:
                p_map[s[end]] -= 1
                # As soon as the count becomes 0 then the criteria for that character to be
                # present has been satisfied (even in case of multiple occurrences of same character).
                if p_map[s[end]] == 0:
                    # 'match' will keep track of how many characters have satisfied the criteria
                    match += 1

            # When the substring under consideration crosses the length of smaller string then we
            # increment start pointer.
            if end - start + 1 > len(p):
                # If the character at outgoing start exists in hashmap we need to increment it back
                # as it is moving out of the window.
                if s[start] in p_map:
                    p_map[s[start]] += 1

                    # If it has reached 1, then match is decremented by 1 as its not a valid anymore
                    if p_map[s[start]] == 1:
                        match -= 1
                start += 1

            # When match is equal to p's length then the current start is a valid index and add to output
            if match == len(p_map):
                output.append(start)
            end += 1

        return output




















