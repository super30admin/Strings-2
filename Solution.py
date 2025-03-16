'''
// Time Complexity :
# Problem 1 - O(m*n) - Brute force,
# Problem 2 - O(m*n) ~ O(max(m,n)), m - length of string, n - length of substring
// Space Complexity :
# Problem 1 - O(1) as there is no extra space
# Problem 2 - O(1) for the hashmap
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :
# Need suggestions in the code logic for Hashing based solution for Problem 1.

// Your code here along with comments explaining your approach
'''
## Problem 1 - Implement strStr()
# Brute force
# We iteratively check for the first occurence of the needle by making sure the difference between the
# haystack and needle is within range
# The first character of the needle matches with any character of the haystack that is our first 
# occurence. 
# Return this index of the first occurence and if there is no match we return -1.

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)
        i = 0
        while i <= m - n:
            if haystack[i] == needle[0]:
                j = 0
                k = i
                while haystack[k] == needle[j]:
                    k += 1; j += 1
                    if j == n:
                        return i
            i += 1
        return -1

# Hashing based solution
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)
        i = 0; j = 0
        needle_hash = 0
        k = 26 ** (n-1)
        for i in range(n):
            ch = needle[i]
            needle_hash = needle_hash * 26 + (ord(ch) - ord('a') + 1)
        source_hash = 0
        for j in range(m):
            if j >= n:
                out_char = haystack[j - n]
                source_hash = source_hash - ((ord(ch) - ord('a') + 1)*k)
            in_char = haystack[j]
            source_hash = source_hash * 26 + (ord(in_char) - ord('a') + 1)
            if source_hash == needle_hash:
                return j - n + 1
        return -1

## Problem 2 - Find All Anagrams in a String
# Check the length of string and substring to search. If substring is greater, return empty array.
# Parse the substring and append the characters in a hashmap with the frequency count
# Parse the string - when hashmap is empty we put the characters IN and increment the count. If all 
# characters match then increment the match count.
# If the hashmap is not empty we take the characters OUT and decrement the count. If all characters
# match then decrement the match count.
# If the match count matches the hashmap length we will append the starting character index in result. 

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        result = []
        m = len(s); n = len(p)
        if n > m: return result
        map_1 = {}
        for i in range(n):
            c = p[i]
            if c not in map_1:
                map_1[c] = 1
            else:
                map_1[c] += 1
        match = 0
        for j in range(m):
            ## IN
            c_in = s[j]
            if c_in in map_1:
                count = map_1[c_in]
                count -= 1
                if count == 0: match += 1
                map_1[c_in] = count
            ## OUT
            if j >= n:
                c_out = s[j - n]
                if c_out in map_1:
                    count = map_1[c_out]
                    count += 1
                    if count == 1: match -= 1
                    map_1[c_out] = count
            if match == len(map_1):
                result.append(j - n + 1)
        return result            