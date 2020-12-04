#As taught in class using dictionary to solve thsi problem by decrementiing and incrementing count as per matched charecter
#Time Complexty: O(n)
#Space Complexity: O(n)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = list()
        map = dict()
        for i in range(len(p)):
            c = p[i]
            if c not in map:
                map[c] = 0
            else:
                map[c] += 1
        match = 0
        for i in range(len(s)):
            inp = s[i]
            if inp in map:
                cnt = map[inp]
                cnt = cnt - 1
                if cnt == 0:
                    match  = match  +1
                map[inp] = cnt
            if i >= len(p):
                out = s[i-len(p)]
                if out in map:
                    cnt = map[inp]
                    cnt = cnt + 1
                if cnt == 0:
                    match = match - 1
            if (match == len(map)):
                result.append(i-len(p)+1)
        return result