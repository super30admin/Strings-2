# Approach:
# We can use Python's built-in string method `find()` to solve this problem.
# The `find()` method returns the index of the first occurrence of a substring (needle) in a string (haystack).
# If the substring is not found, `find()` returns -1, which is exactly what we need for this problem.
# If the needle is an empty string, we return 0 because the empty string is trivially a substring of any string.
# In case we implement manually, we can also iterate over the haystack and compare each substring of length len(needle)
# with needle.

# Time Complexity: O(n * m), where n is the length of haystack and m is the length of needle. This comes from the
# worst-case scenario where we need to compare each substring of length m in haystack.
# Space Complexity: O(1), since we are only using a few variables for indexes.

# Did this code successfully run on Leetcode: Yes, this code works on Leetcode.
# Any problem you faced while coding this: No major issues, simple implementation with `find()`.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # If needle is an empty string, return 0 as per the problem description.
        if not needle:
            return 0
        
        # Use Python's built-in find() method to find the first occurrence of needle in haystack.
        return haystack.find(needle)
