# TC: O(P.length) + O(S.length - P.length)
# SC: O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,93,97]
        pLen = len(p)
        sLen = len(s)
        if pLen > sLen:
            return []
        
        # prime hash of P
        pHash = 1
        for c in p:
            pHash *= primes[ord(c) - ord('a')]
        
        # initializing window hash
        wHash = 1
        for k in range(pLen):
            wHash *= primes[ord(s[k]) - ord('a')]
            
        ans = [0] if wHash == pHash else []
        i, j = 0, pLen
        # computing hash for every slifing window and comparing with hash of p
        while i < sLen - pLen:
            wHash //= primes[ord(s[i]) - ord('a')]
            wHash *= primes[ord(s[j]) - ord('a')]
            if wHash == pHash:
                ans.append(i+1)
            i += 1
            j += 1
            
        return ans