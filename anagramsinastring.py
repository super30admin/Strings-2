# Time Complexity: O(n)
# Space Complexity:O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hash_map = {}
        m = len(p)
        n = len(s)
        result = []

        if n < m:
            return result

        for i in p:
            hash_map[i] = hash_map.get(i, 0) + 1

        match = 0
        for j in range(n):
            c = s[j]
            if c in hash_map:
                freq = hash_map[c]
                freq -= 1
                hash_map[c] = freq
                if freq == 0:
                    match += 1

            if j >= m:
                out_char = s[j - m]
                if out_char in hash_map:
                    freq = hash_map[out_char]
                    freq += 1
                    hash_map[out_char] = freq
                    if freq == 1:
                        match -= 1

            if match == len(hash_map):
                result.append(j - m + 1)

        return result
