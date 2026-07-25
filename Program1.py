## Problem1 
# Implement strStr() (https://leetcode.com/problems/implement-strstr/)

# Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

# Example 1:

# Input: haystack = "hello", needle = "ll"
# Output: 2
# Example 2:

# Input: haystack = "aaaaa", needle = "bba"
# Output: -1
# Clarification:

# What should we return when needle is an empty string? This is a great question to ask during an interview.

# For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        Time Complexity: O(N * M)
        - N is the length of the haystack and M is the length of the needle. 
        - In the worst-case scenario (e.g., haystack = "aaaaaab", needle = "aab"), 
          the inner while loop runs M times for almost every character in N, 
          leading to O(N * M) time complexity.
          
        Space Complexity: O(1)
        - We are only using a few integer variables (hlen, nlen, i, j) for keeping 
          track of lengths and indices. No additional data structures are created 
          that scale with the input size.
        """
        hlen = len(haystack)
        nlen = len(needle)

        # Edge case: If either string is empty, standard convention is to return 0
        # (Though constraints say lengths are >= 1, this is good practice)
        if hlen == 0 or nlen == 0:
            return 0

        # If the needle is longer than the haystack, it's impossible to find a match
        if nlen > hlen:
            return -1

        # Iterate through the haystack
        for i in range(hlen):
            # When the first character matches, check the rest of the needle
            if haystack[i] == needle[0]:
                j = 1
                while j < nlen:
                    # If we've reached the end of the haystack before finishing the needle, 
                    # there's not enough room left for a full match
                    if (i + j) >= hlen:
                        return -1
                    
                    # If characters don't match, break out of the inner loop 
                    # and move to the next starting character in the haystack
                    if haystack[i + j] != needle[j]:
                        break
                        
                    j += 1
                
                # If the inner loop completed without breaking, j will equal nlen,
                # meaning we found a full match starting at index i
                if j == nlen:
                    return i

        # If the outer loop finishes without returning, no match was found
        return -1