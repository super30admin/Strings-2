#Problem 1: Find All Anagrams in a String
#Time Complexity: O(n), n length of s
#Space Complexity O(1), only 26 letters
'''
Get the 26 first primes, perform rolling multiplications,
dividing by first one and muliplying at the next element.
When the value is the same, it means it's an anagram.
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or not p or len(s)<len(p):
            return []
        res=[]
        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        h={chr(ord("a")+i):primes[i] for i in range(26)}
        p_value=1
        mult=1
        for i in range(len(p)):
            p_value*=h[p[i]]
            mult*=h[s[i]]
        for i in range(len(s)-len(p)+1):
            if mult==p_value:
                res.append(i)
            if i!=len(s)-len(p):
                mult=(mult//h[s[i]])*h[s[i+len(p)]]
        return res
