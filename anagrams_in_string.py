'''
438 Find all anagrams in a string
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
"a gentleman" = "elegant man"
"eleven plus two" = "twelve plus one"
"silent" = "listen"
"new york times" = "monkeys write"

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

Let N = len(s), M = len(p)

Solution:
1. Freq count encoder using Sliding Window + Hash Map (easier to understand):
First we count each character in p, store that in a map and generate an encoding string from the freq count, which is a 26-length vector, that stores the count of each English alphabet. Eg. if p=abc, then encoding string = "11100000000000000000000000"

We create a new map (setting freq counts of a-z to 0) to track the freq counts of substrings of s. We traverse over s, maintaining start and end pointers, to extract substrings of length = len(p). When we increase end by 1, we increase the freq count by 1 for the char s[end]. When we increase start by 1, we decrease the freq count by 1 for the char s[start]. We pass the map to the encoder to generate the encoding string (26-length vector). We compare this with the reference encoding string. If it matches, we have found an anagram.
Time: O(N + M), Space: O(1)

2. Sliding Window + Hash Map:
First create a hash map of freq counts of each char in p. Then we slide a window over s to form a substring and update the hash map using the freq counts of characters in the substring of s. When freq count goes down from 1 -> 0, we increase match by 1. When freq count goes up from 0 -> 1, we decrease match by 1. We use the 'match' to track the number of unique characters in p have the same freq count with a substring in s. If all characters match, we add that starting index to the result.

Step 0: Initialize a hash map by maintaining the freq count of characters in p.
Eg. If p = "ABC", then both M = 3, len(map) = 3 (map = {A: 1, B: 1, C: 1})
    If p = "AABC", then M = 4, but len(map) = 3 (map = {A: 2, B: 1, C: 1})

Init start and end pointers to 0 to traverse on s. Define 'match' = no. of unique characters in a substring of s that we have matched with p
E.g.
a) If p = "ABC", then map = {A: 1, B: 1, C: 1}. If substr = "BAC", then match = 3
b) If p = "ABCA", then map = {A: 2, B: 1, C: 1}. If substr = "BAC", then match =

Step 1: Increment end pointer on s to form a substring (window = start:end). If the incoming character (s[end]) is a valid key in the hash map, then we decrease the freq count by 1. Only if the freq count of a char reaches 0, we increase 'match' by 1. (meaning we have found one character from p in the window).

Eg. If p = "AABC", then init of map = {A: 2, B: 1, C: 1}. Then, on traversing s, if there is a substring of s = "ABBC", then map changes to map = {A: 1, B: -1, C: 0}. This means, that the freq count of "ABBC" is such that it is
1 deficit in A, 1 excess in B, exact in C.

Rule: map[A] = 2 (>0) --> deficit - need 2 instances of A to match freq cnt of
      A in p
      map[A] < -2 (<0) --> excess - 2 instances of A in excess of freq cnt of A in p
      map[A] == 0 --> exact - instances of A exactly matches freq cnt of A in p

Thus, using the definiton of match, match = 2 (for B and C).

Step 2: We check if the no. of matching elements in the substring (defined by the variable 'match') == len(map). If yes, add start index to result. If not, go to Step 3.

Step 3: At this point, we check the length of the substring. If len(substring) == len(p), we shrink the window of the substring by 1 by incrementing the start pointer by 1. Shrinking causes the left most character to slip out of the window. If the outgoing character (s[start]) is a valid key in the map, then we increase the freq count by 1 (since we lost 1 instance). Only when the freq count of a char transitions 0 --> 1, we decrease match by 1. (meaning we are 1 instance short).

Step 4: Repeat Step 1. Loop exits when end pointer goes past the last index of s.
https://youtu.be/3XRFYEFTZew?t=2567 (durn 20 min)
Time: O(N + M), Space: O(1)

3. Sliding Window + Hash Map:
This is very similar to the technique described in #2 except one change.
We build two maps - one for p and one for s. pmap is the ref map to maintain freq counts of p. It is never changed once it is initialized.
smap is the map to maintain freq counts of substrings of s. It changes dynamically with the sliding window when we add a char to the window or remove a char from the window. At each addition or removal of char, we update the smap and check if freq count of smap matches the freq count of pmap.

Time: O(N + M), Space: O(1)

'''

from collections import defaultdict

def findAnagrams_1(s, p):
    ''' Time: O(N + M), Space: O(1) '''
    def encode_str(map):
        s = ""
        for i in range(26): # O(1)
            s += str(map[i])
        return s

    if not s or not p or len(p) > len(s):
        return []

    N = len(s)
    M = len(p)
    result = []

    map = defaultdict(int)
    for c in p:
        map[ord(c) - ord('a')] += 1
    encoded_tgt = encode_str(map) # O(M)

    start = 0
    map = defaultdict(int)
    for end in range(N): # O(N)
        map[ord(s[end]) - ord('a')] += 1 # O(1)
        encoded_sub = encode_str(map) # O(1)

        if encoded_sub == encoded_tgt:
            result.append(start)

        len_sub = end - start + 1
        if len_sub == M:
            map[ord(s[start]) - ord('a')] -= 1 # O(1)
            start += 1
    return result

def findAnagrams_2(s, p):
    ''' Time: O(N + M), Space: O(1) '''
    if not s or not p or len(p) > len(s):
        return []

    N = len(s)
    M = len(p)
    map = defaultdict(int)
    match = 0 # how many UNIQUE characters in p
    # have the exact freq count in the current substr
    result = []
    for c in p: # O(M)
        map[c] += 1

    start, end = 0, 0
    while end < N: # O(N)
        le = end - start +  1

        # incoming char
        cin = s[end]
        if cin in map:
            map[cin] -= 1
            # If map[cin] goes from 2 -> 1: 2 deficits to 1 deficit
            # If map[cin] goes from 1 -> 0: exact freq count ... first time
            # exact ... increase match
            # If map[cin] goes from 0 -> -1: exact freq count to 1 excess
            if map[cin] == 0:
                match += 1

        # outgoing char
        if le > M:
            cout = s[start]
            if cout in map:
                map[cout] += 1
                # If map[cout] goes from -1 -> 0: excess to exact (we haven't
                # lost a matching char)
                # If map[cout] goes from 0 -> 1: exact to deficit (we have lost
                # a matching char) ... 1st time in deficit ... decrease match
                # If map[cout] goes from 1 -> 2: 1 deficit to 2 deficit (we
                # didn't have a match earlier and we still don't have a match)
                if map[cout] == 1:
                    match -= 1
            start += 1

        if match == len(map):
            result.append(start)

        end += 1
    return result

def findAnagrams_3(s, p):
    ''' Time: O(N + M), Space: O(1) '''
    if not s or not p or len(p) > len(s):
        return []

    N = len(s)
    M = len(p)
    pmap = defaultdict(int) # ref map of pattern p
    for c in p: # O(M)
        pmap[c] += 1

    smap = defaultdict(int) # map of string s
    match = 0 # how many UNIQUE characters in p
    # have the exact freq count in the current substr

    i, j = 0, 0 # start and end pointer
    result = []
    while j < N: # O(N)
        le = j - i + 1 # len of substr
        cin, cout = s[j], s[i]

        # incoming char
        if cin in pmap:
            smap[cin] += 1
            # If we just hit the exact required count, increment match
            if smap[cin] == pmap[cin]:
                match += 1

        if le > M:
            # outgoing char
            if cout in pmap:
                # If freq count was perfectly matching already, removing cout
                # breaks the match
                if smap[cout] == pmap[cout]:
                    match -= 1
                smap[cout] -= 1
            i += 1 # advance start pointer

        if match == len(pmap):
            result.append(i)

        #substr = s[i:j+1]
        #print(f"substr = {substr}, smap = {smap}, match = {match}, result = {result}")

        j += 1 # advance end pointer

    return result

def run_tests():
    tests = [("cbaebabacd", "abc", [0,6]),
             ("abcbaabcdef", "abca", [2,4]),
             ("abaacbabc", "abc", [3,4,6]),
             ("abab", "ab", [0,1,2]),
             ("baa", "aa", [1]),
    ]
    # tests = [("abcbaabcdef", "abca", [2,4])]
    for test in tests:
        s, p, ans = test[0], test[1], test[2]
        print(f"\np = {p}")
        print(f"s = {s}")
        for method in [1, 2, 3]:
            if method == 1:
                indices = findAnagrams_1(s, p)
            elif method == 2:
                indices = findAnagrams_2(s, p)
            elif method == 3:
                indices = findAnagrams_3(s, p)
            print(f"Method {method}: Start indices of anagrams in sample string = {indices}")
            passed = (ans == indices)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()
