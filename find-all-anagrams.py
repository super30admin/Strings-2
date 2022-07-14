# Approach Sliding window with prime product
# TC : O(n) where n is len of the string s
# SC : O(1) as we don't use any extra space
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101]
        # base case
        if len(s) < len(p): return []
        # get prime product of p string
        pPrime = self.getPrime(p)
        l = 0
        res = []
        currPrime = 0
        
        # loop over s string
        for r in range(len(s)):
            # keep expanding window and adding to prime product
            c = s[r]
            currPrime = currPrime + (primes[ord(c)-96-1] * (ord(c)-96))
            # if currPrime become what we are looking for add left pointer index to result
            if currPrime == pPrime:
                c = s[l]
                res.append(l)
            # if window is as big as len(p), we need to shrink it from left end to maintain the size
            # when we add new character from the right end
            if (r-l+1) == len(p):
                c = s[l] # so pick left index character and subtract it from currPrime
                currPrime = currPrime - (primes[ord(c)-96-1] * (ord(c)-96))
                l += 1
        
        return res

    
    def getPrime(self, s: str)-> int:
        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101]
        r = 0
        for c in s:
            r += primes[ord(c)-96-1] * (ord(c)-96)
        return r