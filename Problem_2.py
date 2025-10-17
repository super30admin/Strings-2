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

2. Freq count update using Sliding Window + Hash Map (slightly harder to understand, more bookkeeping):
First create a hash map of freq counts of each char in p. Then we slide a window over s to form a substring and update the hash map using the freq counts of characters in the substring of s. When freq count goes down from 1 -> 0, we increase match by 1. When freq count goes up from 0 -> 1, we decrease match by 1. We use the 'match' to track the number of unique characters in p have the same freq count with a substring in s. If all characters match, we add that starting index to the result.

Step 0: Initialize a hash map by maintaining the freq count of characters in p.
Eg. If p = "ABC", then both M = 3, len(map) = 3 (map = {A: 1, B: 1, C: 1})
    If p = "AABC", then M = 4, but len(map) = 3 (map = {A: 2, B: 1, C: 1})

Init start and end pointers to 0 to traverse on s. Define 'match' = no. of unique characters in p that satisifes two conditions:
    a) The char in p is also present in a substring of s
    b) The char in the substring of s has the same or higher freq count as the char in p.


Step 1: Increment end pointer on s to form a substring (window = start:end). If the incoming character (s[end]) is a valid key in the hash map, then we decrease the freq count by 1. Only if the freq count of a char reaches 0, we increase 'match' by 1. (meaning we have found one character from p in the window).

Eg. If p = "AABC", then init of map = {A: 2, B: 1, C: 1}. Then, on traversing s, if there is a substring of s = "ABBC", then the freq of counts of chars in s are used to update the map. Then map changes to map = {A: 1, B: -1, C: 0}.
In the substring, A has a lower freq than freq of A in p (since map[A] > 0)
In the substring, B has a higher freq than freq of B in p (since map[B] < 0)
In the substring, C has the same freq as freq of C in p (since map[C] = 0)
Thus, using the definiton of match, match = 2 (for B and C).

Step 2: We check if the no. of matching elements in the substring (defined by the variable 'match') == len(map). If it is add the start index to the result. If not, go to Step 3.

Step 3: At this point, we check the length of the substring. If len(substring) == len(p), we shrink the window of the substring by 1 by incrementing the start pointer by 1. Shrinking causes the left most character to slip out of the window. If the outgoing character (s[start]) is a valid key in the map, then we increase the freq count by 1. Only when the freq count of a char reaches 1 (from 0), we decrease the no. of matching elements by 1. (meaning we have lost one character from the substring).
Note that: When freq count of a char (say 'a') is:
    a) +ve number (say 2), it means the window is short of 2 more instances of 'a'. Thus, the window is deficient.
    b) 0, it means the window has the same number of 'a's as the number of 'a's in t. Thus, the window is sufficient.
    c) -ve number (say -2), it it means the window has 2 instances of 'a' more than the instances of 'a' in t. Thus, the window is excessive.
Step 3: Repeat Step 1. Loop exits when end pointer goes past the last index of s.

https://youtu.be/3XRFYEFTZew?t=2581

Time: O(N + M), Space: O(1)

3. Freq count update using Sliding Window + Hash Map (slightly harder to understand, more bookkeeping):
This is quite similar to the technique described in #2 except one change.
In #2, 'match' was defined by the number of unique characters in p. In this technique, we define 'match' = no. of characters in p, discarding the unique constraint.

The way map is updated differs as follows:

#2) if map[incoming] == 0:
        match += 1

    if map[outgoing] == 1:
        match -= 1

    if match == len(map):
        start_indices_anagrams.append(start)

#3) if map[incoming] >= 0:
        match += 1

    if map[outgoing] > 1:
        match -= 1

    if match == M:
        start_indices_anagrams.append(start)

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
    start_indices_anagrams = []

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
            start_indices_anagrams.append(start)

        len_sub = end - start + 1
        if len_sub == M:
            map[ord(s[start]) - ord('a')] -= 1 # O(1)
            start += 1
    return start_indices_anagrams

def findAnagrams_2(s, p):
    ''' Time: O(N + M), Space: O(1) '''
    if not s or not p or len(p) > len(s):
        return []

    N = len(s)
    M = len(p)
    map = defaultdict(int)
    match = 0 # no. of unique chars in p that match with a substring of s
    start_indices_anagrams = []
    for c in p: # O(M)
        map[c] += 1

    start, end = 0, 0
    while start <= end and end < N: # O(N)
        incoming = s[end]
        if incoming in map:
            map[incoming] -= 1
            # If freq goes from 2 -> 1, we haven't added a matching char
            # If freq goes from 1 -> 0, we have added a matching char
            # If freq goes from -1 -> 0, we haven't added a matching char
            if map[incoming] == 0:  # first time map[char] goes from 0 to +ve
                match += 1

        if match == len(map):
            start_indices_anagrams.append(start)

        #print(f"start = {start}, end = {end}, map = {map}, match = {match}, substr = {s[start:end+1]}")
        len_sub = end - start + 1
        if len_sub == M:
            outgoing = s[start]
            if outgoing in map:
                map[outgoing] += 1
                # If freq goes from -1 -> 0, we haven't lost a matching char
                # If freq goes from 0 -> 1, we have lost a matching char
                # If freq goes from 1 -> 2, we haven't lost a matching char
                if map[outgoing] == 1: # first time map[char] goes from 0 to +ve
                    match -= 1
            start += 1
        end += 1
    return start_indices_anagrams

def findAnagrams_3(s, p):
    ''' Time: O(N + M), Space: O(1) '''
    if not s or not p or len(p) > len(s):
        return []

    N = len(s)
    M = len(p)
    map = defaultdict(int)
    match = 0 # no. of unique chars in p that match with a substring of s
    start_indices_anagrams = []
    for c in p: # O(M)
        map[c] += 1

    start, end = 0, 0
    while start <= end and end < N: # O(N)
        incoming = s[end]
        if incoming in map:
            map[incoming] -= 1
            # If freq goes from 2 -> 1, we have added a matching char
            # If freq goes from 1 -> 0, we have added a matching char
            # If freq goes from -1 -> 0, we haven't added a matching char
            if map[incoming] >= 0: # increase match all 0 or +ve values
                match += 1

        if match == M:
            start_indices_anagrams.append(start)

        #print(f"start = {start}, end = {end}, map = {map}, match = {match}, substr = {s[start:end+1]}")
        len_sub = end - start + 1
        if len_sub == M:
            outgoing = s[start]
            if outgoing in map:
                map[outgoing] += 1
                # If freq goes from -1 -> 0, we haven't lost a matching char
                # If freq goes from 0 -> 1, we have lost a matching char
                # If freq goes from 1 -> 2, we have lost a matching char
                if map[outgoing] > 0: # decrease match all +ve values
                    match -= 1
            start += 1
        end += 1
    return start_indices_anagrams


def run_findAnagrams():
    tests = [("cbaebabacd", "abc", [0,6]),
             ("abcbaabcdef", "abca", [2,4]),
             ("abab", "ab", [0,1,2]),
             ("baa", "aa", [1]),
    ]
    #tests = [("abcbaabcdef", "abca", [2,4])]
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
            success = (ans == indices)
            print(f"Pass: {success}")
            if not success:
                return

run_findAnagrams()
