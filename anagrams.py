# sliding window
# O(n) time | O(m) space # m - length of pattern
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pattern_dict = dict()
        n=len(p)
        for ch in p:
            if ch not in pattern_dict:
                pattern_dict[ch] = 0
            pattern_dict[ch] += 1
        
        count = len(pattern_dict)
        anagrams = []
        ptr = 0
        while ptr < len(s):
            if ptr >= n:
                ch = s[ptr-n]
                #outgoing character
                if ch in pattern_dict:
                    if pattern_dict[ch]==0:
                        count += 1
                    pattern_dict[ch] += 1
            #incoming character
            ch = s[ptr]
            if ch in pattern_dict:
                pattern_dict[ch] -= 1
                if pattern_dict[ch]==0:
                    count -= 1
            if count==0:
                anagrams.append(ptr-n+1) 
            ptr += 1
        
        return anagrams


# using prime numbers 
# space O(1) | time O(n+m)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101]
        n = len(p)
        pprime = 1
        for ch in p:
            pprime *= primes[ord(ch)-97] 
        
        anagrams = []
        sprime = 1
        ptr = 0
        while ptr<len(s):
            sprime *= primes[ord(s[ptr])-97]
            if ptr>=n:
                # divide by the outgoing character value
                sprime = sprime//primes[ord(s[ptr-n])-97]
                
            if sprime == pprime:
                anagrams.append(ptr-n+1)
            ptr+=1
                
        return anagrams