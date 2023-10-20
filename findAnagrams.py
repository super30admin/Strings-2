from collections import Counter


class Solution:
    def findAnagrams(self, s: str, p: str):
        ns = len(s)
        np = len(p)
        if ns < np:
            return []

        p_count = Counter(p)
        s_count = Counter()

        output = []
        for i in range(ns):
            s_count[s[i]] += 1
            if i >= np:
                if s_count[s[i-np]] == 1:
                    del s_count[s[i-np]]
                else:
                    s_count[s[i-np]] -= 1
            print(i, s_count)
            if s_count == p_count:
                output.append(i-np+1)

        return output
#TC: O(n)
#SC: O(1)