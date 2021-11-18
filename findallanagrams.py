"""https://leetcode.com/problems/find-all-anagrams-in-a-string/"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ###basecase
        if len(s) < len(p):
            return []
        mapref = {}
        mapstr = {}
        output = []
        for c in p:
            if c in mapref:
                mapref[c] += 1
            else:
                mapref[c] = 1

        ##iterate through s decide window size
        for i in range(len(s)):
            ##adding to the window
            if s[i] in mapstr:
                ##add letter to right
                mapstr[s[i]] += 1

            else:

                mapstr[s[i]] = 1
                ###now we have to slice the window, remove from the window

            if i >= len(p):
                if mapstr[s[i - len(p)]] == 1:
                    mapstr.pop(s[i - len(p)])
                    # del mapstr[s[i-len(p)]]
                else:
                    mapstr[s[i - len(p)]] -= 1

                ###we have a window lets check if the two hashmaps are equal
            if mapref == mapstr:
                output.append(i - len(p) + 1)
                # output.append(s[i])

        return output

