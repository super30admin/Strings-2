class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # # Approach 1 checking hashmaps
        # # Time: O(n)
        # # Space Complexity: O(n)
        # result = []
        # def check(hmapp, hmaps):
        #     for k,v in hmapp.items():
        #         if hmaps[k] != v:
        #     # if hmapp != hmaps: Alternate method to check hashmaps are same or not
        #             return False
        #     return True

        # if len(s) < len(p):
        #     return []
        # hmapp = defaultdict(int)
        # hmaps = defaultdict(int)
        # # Put characters of pattern in hmap
        # for i in p:
        #     hmapp[i] += 1
        # # print("hmapp", hmapp)

        # p1 = 0
        # for p2 in range(len(s)):
        #     if (p2-p1) < len(p):
        #         hmaps[s[p2]] += 1
        #     else:
        #         if check(hmapp, hmaps):
        #             result.append(p1)
        #         hmaps[s[p1]] -= 1
        #         # if hmaps[s[p1]] == 0:
        #         #     del hmaps[s[p1]]
        #         p1 += 1
        #         hmaps[s[p2]] += 1
        #     # print(hmaps)
        # if check(hmapp, hmaps):
        #     result.append(p1)

        # return result

        # Approach 2 creating unique hash values
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        if len(p) > len(s):
            return []
        result = []
        # Generate 26 prime numbers for each alphabet
        primes = []

        def generatePrime(primes):
            primes.append(2)
            for i in range(3, 200):
                for j in range(2, (i // 2) + 1):
                    if i % j == 0:
                        break
                else:
                    primes.append(i)
                if (len(primes) == 26):
                    break

        generatePrime(primes)
        # print(primes)

        # Generating a unique hash value for p string
        p_hash = 0
        for i in p:
            p_hash += (ord(i) - 97) * primes[ord(i) - 97]
        # print(p_hash)

        # Sliding window while calculating hash values
        s_hash = 0
        p1 = 0
        for p2 in range(len(s)):
            if (p2 - p1) < len(p):
                s_hash += (ord(s[p2]) - 97) * primes[ord(s[p2]) - 97]
            else:
                if s_hash == p_hash:
                    result.append(p1)

                s_hash -= (ord(s[p1]) - 97) * primes[ord(s[p1]) - 97]
                p1 += 1
                s_hash += (ord(s[p2]) - 97) * primes[ord(s[p2]) - 97]
        if s_hash == p_hash:
            result.append(p1)

        return result


















