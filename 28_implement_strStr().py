'''

## Problem 28: Implement strStr()

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
    or -1 if needle is not part of haystack.

    Clarification:
        What should we return when needle is an empty string?
        This is a great question to ask during an interview.
        For the purpose of this problem, we will return 0 when needle is an empty string.
        This is consistent to C's strstr() and Java's indexOf().

## Examples:
    Example 1:
        Input: haystack = "hello", needle = "ll"
        Output: 2
    Example 2:
        Input: haystack = "aaaaa", needle = "bba"
        Output: -1

## Constraints:
    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.

## Time complexity : O(n), where n is length of haystack.

## Space complexity: O(1), no auxiliary space is used.

'''

def get_input():
    print("Enter the haystack string: ", end = "")
    haystack = input()
    print()
    print("Enter the needle string: ", end = "")
    needle = input()
    print()
    return haystack, needle

class Solution:
    def strStr_traversal(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0

        substr_len = len(needle)
        for i in range(len(haystack) - substr_len + 1):
            if haystack[i] == needle[0]:
                if haystack[i:i+substr_len] == needle:
                    return i
        return -1

    def strStr_inbuilt_method(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0

        answer = -1 if needle not in haystack else haystack.find(needle)
        return answer

# Driver code
solution = Solution()
haystack, needle = get_input()
print(f"Input haystack string: {haystack}")
print(f"Input needle string: {needle}")
print(f"Approach 1: String traversal: Starting index of needle in haystack is: {solution.strStr_traversal(haystack, needle)}")
print(f"Approach 2: Using inbuilt method:: Starting index of needle in haystack is: {solution.strStr_inbuilt_method(haystack, needle)}")
