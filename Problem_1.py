'''
28 Find the Index of the First Occurrence in a String
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

Let N = len(needle), M = len(character)
Solution
1. Sliding window
We go through each possible starting point in haystack to match the needle. If the first characters match, we check the rest character by character. If all characters of needle match in haystack, we return that index.

https://youtu.be/D6fev-b_JUc?t=315
https://youtu.be/D6fev-b_JUc?t=958 (inefficiency with sliding window approach)
Time: O(NM), Space: O(1)

2. KMP (Knuth-Morris-Pratt) algorithm
First, we build the LPS (Longest Prefix Suffix) array for the needle. Then we scan the haystack with the help of the LPS to skip unnecessary comparisons. When all characters match, we return the starting index.

https://youtu.be/D6fev-b_JUc?t=1033

https://www.youtube.com/watch?v=V5-7GzOfADQ
https://www.youtube.com/watch?v=GTJr8OvyEVQ

https://blog.seancoughlin.me/find-the-index-of-the-first-occurrence-in-a-string-naive-and-kmp-solutions

Time: O(N+M), Space: O(N)
'''
# def strStrSlidingWindow(haystack: str, needle: str) -> int:
#     ''' Time: O(NM), Space: O(1) '''
#     if needle:
#         return 0

#     M = len(needle)
#     N = len(haystack)
#     start = -1
#     for hi in range(N-M+1): # O(N)
#         if haystack[hi:hi+M] == needle: # O(M)
#             start = hi
#             break
#     return start

def strStr_SlidingWindow(haystack: str, needle: str) -> int:
    ''' Time: O(NM), Space: O(1) '''
    N = len(needle)
    M = len(haystack)
    if N > M:
        return -1
    i = 0 # pointer in haystack
    while i < M:
        if haystack[i] == needle[0]:
            k = i # temp pointer in haystack
            j = 0 # pointer in needle
            while k < M and j < N and haystack[k] == needle[j]:
                k += 1
                j += 1
            if j == N:
                return i
        i += 1
    return -1

def strStr_KMP(haystack: str, needle: str) -> int:
    ''' Time: O(N+M), Space: O(1) '''
    def lps(s):
        n = len(s)
        i = 1  # pointer in haystack
        j = 0  # pointer in needle
        lps = [0]*N
        lps[0] = 0 # value at 1st index of lps = 0 always
        while i < n:
            if s[i] == s[j]:
                j += 1
                lps[i] = j
                i += 1
            if s[i] != s[j]:
                if j > 0:
                    j = lps[j-1]
                elif j == 0:
                    lps[i] = 0
                    i += 1
        return lps

    N = len(needle)
    M = len(haystack)
    i = 0  # pointer in haystack
    j = 0  # pointer in needle
    if N > M:
        return -1
    lps = lps(needle)
    while i < M:
        if haystack[i] == needle[j]:
            i += 1
            j += 1
            if j == N:
                return i - N
        elif haystack[i] != needle[j] and j > 0:
            j = lps[j-1]
        elif haystack[i] != needle[j] and j == 0:
            i += 1
    return -1

def run_strStr():
    tests = [("sadbutsad", "sad", 0), ("leetcode","leeto", -1), ('aaaab', 'aab', 2), ("aaaaa","bba", -1), ("icecreamice", "mice", 7), ]
    for test in tests:
        haystack, needle, ans = test[0], test[1], test[2]
        print(f"\nNeedle = {needle}")
        print(f"Haystack = {haystack}")
        for method in ['SlidingWindow', 'KMP']: #['SlidingWindow']:
            if method == 'SlidingWindow':
                index = strStr_SlidingWindow(haystack, needle)
            elif method == 'KMP':
                index = strStr_KMP(haystack, needle)
            print(f"Method {method}: Index of Needle in Haystack = {index}")
            success = (ans == index)
            print(f"Pass: {success}")
            if not success:
                return

run_strStr()