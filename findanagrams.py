class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hmap = {'a': 2, 'b': 3, 'c': 5, 'd': 7, 'e': 11, 'f': 13, 'g': 17, 'h': 19, 'i': 23, 'j': 29, 'k': 31, 'l': 37, 'm': 41, 'n': 43, 'o': 47, 'p': 53, 'q': 59, 'r': 61, 's': 67, 't': 71, 'u': 73, 'v': 79, 'w': 83, 'x': 89, 'y': 97, 'z': 101}
        n = len(s)
        m = len(p)
        if (n < m):
            return []
        i = 0
        prod = 1
        target = 1
        while(i < m):
            prod = prod * hmap[s[i]]
            target = target * hmap[p[i]]
            i += 1
        res = []
        i = m-1
        j = 0
        while(i<n):
            if prod == target:
                res.append(j)
            if i == n - 1:
                return res
            i += 1
            prod = prod // hmap[s[j]]
            prod = prod * hmap[s[i]]
            j += 1
        return res




