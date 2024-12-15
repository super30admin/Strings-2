# TC: O(n)
# SC: O(1)

def findAnagrams(s, p):
    result = []
    s_count = [0] * 26
    p_count = [0] * 26

    if len(s) < len(p):
        return result

    for i in range(len(p)):
        s_count[ord(s[i]) - ord('a')] += 1
        p_count[ord(p[i]) - ord('a')] += 1

    start = 0
    end = len(p)

    if s_count == p_count:
        result.append(start)

    while end < len(s):
        s_count[ord(s[start]) - ord('a')] -= 1
        s_count[ord(s[end]) - ord('a')] += 1

        if s_count == p_count:
            result.append(start + 1)

        start += 1
        end += 1

    return result