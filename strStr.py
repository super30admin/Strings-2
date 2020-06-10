#Problem 1: Implement strStr()
#Time Complexity: O(n), n length of haystack
#Space Complexity O(L), length of needle.

'''
Use 26 primes, while keeping a polynomial with powers of
2 to keep track of the order. Update adequatly each turn in O(1).We keep a hashmap of the powers to not keep calculating them.
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        if len(haystack)<len(needle):
            return -1

        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        h={chr(ord("a")+i):primes[i] for i in range(26)}
        powers,power={0:1},1
        for i in range(1,len(needle)):
            power*=2
            powers[i]=power
        needle_val,mult=0,0
        for i in range(len(needle)):
            needle_val+=h[needle[i]]*powers[len(needle)-i-1]
            mult+=h[haystack[i]]*powers[len(needle)-i-1]

        for i in range(len(haystack)-len(needle)+1):
            if mult==needle_val:
                return i
            mult=(mult-h[haystack[i]]*powers[len(needle)-1])*2+h[haystack[min(len(haystack)-1,i+len(needle))]]
        return -1
