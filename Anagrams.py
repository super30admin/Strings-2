# TC - O(n)
# SC - O(1)
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        wsize = len(p)
        szize = len(s)

        # if wsize > szize:
        #     return []

        window = 0
        start = 0

        result = []

        pmap = {}
        smap = {}

        pmap = Counter(p)
        i = 0

        for i in range(szize):
            char = s[i]

            if char not in smap:
                smap[char] = 0
            smap[char] += 1

            if i >= wsize:
                if smap[s[start]] == 1:
                    del smap[s[start]]
                else:
                    smap[s[start]] -= 1
                start = start + 1

            if smap == pmap:
                result.append(start)

        return result
