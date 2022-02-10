class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        hashMap = {e:p.count(e) for e in set(p)}
        match = 0
        result = []
        for i in range(len(s)):
            if hashMap.has_key(s[i]):
                cnt = hashMap[s[i]]
                cnt -= 1
                if cnt == 0:
                    match += 1
                hashMap[s[i]] = cnt
            if i >= len(p):
                out = s[i-len(p)]
                if hashMap.has_key(out):
                    cnt = hashMap[out]
                    cnt += 1
                    if cnt == 1:
                        match -= 1
                    hashMap[out] = cnt
            if match == len(hashMap):
                result.append(i-len(p)+1)
        return result