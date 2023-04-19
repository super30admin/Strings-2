# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes = [2]
        result = []
        self.generatePrime(primes)
        phash = self.generateHash(p,primes)
        print(phash)
        shash = 1
        for i in range(len(s)):
            shash *= primes[ord(s[i])-97]
            if i >= len(p):
                shash //= primes[ord(s[i-len(p)])-97]
            if shash == phash:
                result.append(i-len(p)+1)
        return result

    def generatePrime(self,primes):
        for i in range(3,200):
            for j in range(2,(i//2)+1):
                if i%j == 0:
                    break
            else:
                primes.append(i)
            if (len(primes) == 26):
                break

    def generateHash(self,key,primes):
        result = 1
        for i in key:
            result *= primes[ord(i)-97]
        return result