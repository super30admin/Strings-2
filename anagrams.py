# Time complexity: O(n)
# Space complexity: O(1)

from collections import Counter

def findAnagrams(s, p):
    p_str_count = Counter(p)
    s_str_count = Counter(s[:len(p) - 1])
    result = []

    for i in range(len(p) - 1, len(s)):
        s_str_count[s[i]] += 1
        if s_str_count == p_str_count:
            result.append(i - len(p) + 1)
        s_str_count[s[i - len(p) + 1]] -= 1
        if s_str_count[s[i - len(p) + 1]] == 0:
            del s_str_count[s[i - len(p) + 1]]

    return result
