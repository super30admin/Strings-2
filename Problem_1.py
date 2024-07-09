"""
Time Complexity - O(n)
Space Complexity - O(1)

Works on Leetode
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        Brute Force: start from first index of haystack, create a substring of length needle and check if the two strings match.
        Return i
        """

        #Using Rolling Hash
        #create a hash for the search key, we first multiply the hash by 26 and add the character value 
        hashP = 0
        hashS = 0
        m = len(haystack)
        n = len(needle)
        for c in needle:
            hashP = hashP*26+(ord(c)-ord('a')+1)
        
        #calculate the hash from the search string
        for i in range(m):
            #if window size is greater than the size of the search key, we remove a character from the string by substracting from the
            #hash 26^(last index from right of the string)*character value
            if i >= n:
                c = haystack[i-n]
                hashS = hashS-26**(n-1)*(ord(c) - ord('a')+1)
            #we add to hash the next 
            hashS = hashS*26+(ord(haystack[i])-ord('a') + 1)
            if hashP == hashS:
                return i-n+1
        return -1