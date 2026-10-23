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

Let N = len(needle), M = len(haystack)
Solution
1. Brute Force
We go through each possible starting point in haystack to match the needle. If the first characters match, we check the rest character by character. If all characters of needle match in haystack, we return that index.
Time: O(NM), Space: O(1)
https://youtu.be/D6fev-b_JUc?t=315
https://youtu.be/D6fev-b_JUc?t=958 (inefficiency with sliding window approach)


2. Rolling Hash (Rabin-Karp)
We first compute the target hash value for the needle and the initial hash value for the first window (haystack[0:N]) of the haystack .

Next, a sliding window of fixed length moves across the haystack from left to right. At each position, the algorithm directly compares the current window's hash to the target hash, returning the starting index upon a match.

To maintain linear time complexity, the window hash is updated in O(1) time by subtracting the contribution of the outgoing character from the window hash value, and adding the contribution of the incoming character. The window start and end pointers advance 1 step to the right. If the traversal finishes without a match, the function returns -1

Note: The contribution to be subtracted has to be based on 26^(N-1) and not 10^(N-1). But why? Ans: To avoid collisions, we need a base that is at least as large as the size of the alphabet set.
E.g.
1. Collision: 'ba' = 2*10 + 1 = 21, 'ak' = 1*10 + 11 = 21
2. No Collision: 'ba' = 2*26 + 1 = 53, 'ak' = 1*26 + 11 = 37
Time: O(N+M), Space: O(N)
https://youtu.be/cBY7fVPOTX8?t=2414

2. KMP (Knuth-Morris-Pratt) algorithm
First, we build the LPS (Longest Prefix Suffix) array for the needle. Then we scan the haystack with the help of the LPS to skip unnecessary comparisons. When all characters match, we return the starting index.
Time: O(N+M), Space: O(N)

https://youtu.be/D6fev-b_JUc?t=1033

https://www.youtube.com/watch?v=V5-7GzOfADQ
https://www.youtube.com/watch?v=GTJr8OvyEVQ

https://blog.seancoughlin.me/find-the-index-of-the-first-occurrence-in-a-string-naive-and-kmp-solutions


'''
def strStr_BruteForce(haystack: str, needle: str) -> int:
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

def strStr_RollingHash(haystack: str, needle: str) -> int:
    ''' Rabin-Karp Algorithm
        Time: O(N + M), Space: O(1)
    '''
    N = len(needle)
    M = len(haystack)
    if N > M:
        return -1

    # compute needle's hash
    BASE = 26
    nhash = 0
    for c in needle: # O(N)
        nhash = nhash*BASE + (ord(c) - ord('a') + 1)

    # compute the haystack's hash for the first N characters in haystack
    hhash = 0
    for c in haystack[0:N]: # O(M)
        hhash = hhash*BASE + (ord(c) - ord('a') + 1)

    start, end = 0, N-1 # end pointer on haystack
    const = pow(BASE, N-1)
    while end <= M-1:
        if hhash == nhash:
           return start

        # no more incoming characters
        if end == M - 1:
            break

        cin = haystack[end+1]
        cout = haystack[start]

        # subtract the contribution of outgoing char from hhash
        hhash = hhash - (ord(cout) - ord('a') + 1)*const

        # add the contribution of incoming char to hhash
        hhash = hhash*BASE + (ord(cin) - ord('a') + 1)

        start += 1
        end += 1
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

def run_tests():
    tests = [("sadbutsad", "sad", 0),
             ("aabacabcabc", "acab", 3),
             ("leetcode","leeto", -1),
             ('aaaab', 'aab', 2),
             ("aaaaa","bba", -1),
             ("icecreamice", "mice", 7),
    ]
    for test in tests:
        haystack, needle, ans = test[0], test[1], test[2]
        print(f"\nNeedle = {needle}")
        print(f"Haystack = {haystack}")
        for method in ['BruteForce', 'RollingHash', 'KMP']:
            if method == 'BruteForce':
                index = strStr_BruteForce(haystack, needle)
            if method == 'RollingHash':
                index = strStr_RollingHash(haystack, needle)
            elif method == 'KMP':
                index = strStr_KMP(haystack, needle)
            print(f"Method {method}: Index of Needle in Haystack = {index}")
            passed = (ans == index)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")
run_tests()