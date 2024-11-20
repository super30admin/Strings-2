class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        hmap = {}
        result = []
        count = 0

        m = len(s)
        n = len(p)

        for c in p:
            if c in hmap:
                hmap[c] += 1
            else:
                hmap[c] = 1

        for i in range(m):
            inp = s[i]
            if inp in hmap:
                freq = hmap[inp]
                freq -= 1
                hmap[inp] = freq
                if(freq == 0):
                    count += 1

            if(i>=n):
                out = s[i-n]
                if(out in hmap):
                    freq = hmap[out]
                    freq += 1
                    hmap[out] = freq
                    if(freq == 1):
                        count -= 1

            if(count == len(hmap)):
                result.append(i-n+1)

        return result
                
        