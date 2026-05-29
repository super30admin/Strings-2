class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        m = len(s)
        n = len(p)

        map = {}
        for c in p:
            if c in map:
                map[c] += 1
            else:
                map[c] = 1

        match = 0
        for i in range(m):
            in_char = s[i]
            if in_char in map:
                frq = map[in_char]
                frq -= 1
                map[in_char] = frq
                if frq == 0:
                    match += 1

            if i >= n:
                out_char = s[i - n]
                if out_char in map:
                    frq = map[out_char]
                    frq += 1
                    map[out_char] = frq
                    if frq == 1:
                        match -= 1

            if match == len(map):
                result.append(i - n + 1)

        return result

# Time: O(m + n)
# Space: O(1)