# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

# Brute force
# We iteratively check for the first occurence of the needle by making sure the difference between the
# haystack and needle is within range
# The first character of the needle matches with any character of the haystack that is our first 
# occurence. 
# Return this index of the first occurence and if there is no match we return -1.

## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

# Check the length of string and substring to search. If substring is greater, return empty array.
# Parse the substring and append the characters in a hashmap with the frequency count
# Parse the string - when hashmap is empty we put the characters IN and increment the count. If all 
# characters match then increment the match count.
# If the hashmap is not empty we take the characters OUT and decrement the count. If all characters
# match then decrement the match count.
# If the match count matches the hashmap length we will append the starting character index in result. 