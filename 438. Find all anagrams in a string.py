# Time complexity = O(n) as we are iterating on the string only once
# Space complexity = O(26)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        m = len(p)
        n = len(s)
        result = []
        curr_prod = 1 # It'll determine the current product of the chars in s 
        if m > n:
            return result
        prime_product = 1 # It'll determine the prime product of pattern
        for i in range(m): # Calculating the prime product
            c = p[i]
            prime_product *= primes[ord(c) - ord('a')]
        #print("Prime product of p is: ", prime_product)
        for i in range(n):
            inc = s[i] # Incoming char
            curr_prod *= primes[ord(inc) - ord('a')] # Adding incoming char in curr product
            if i >= m: # If the len of i id grater than pattern
                out = s[i - m]  # Remove first element to keep window of len(p)
                curr_prod//= primes[ord(out) - ord('a')] # Divide the curr product by the prime value of element going
            if curr_prod == prime_product: # Base condition
                result.append(i - m + 1)
        
        return result
