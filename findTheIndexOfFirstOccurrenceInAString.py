# Time Complexity : O(n), where n is the length of s.
# Space Complexity : O(1)

# Approach 1: Rabin-Karp Algorithm
# The Rabin-Karp algorithm searches for a substring (needle) in a string (haystack) using hashing.
# It is different from the form factorization method, which only works for anagrams.
# 1. Calculate the hash value of the needle string.
# 2. Initialize a variable to store the hash value of the current window in the haystack string.
# 3. Iterate through the haystack string, updating the hash value of the current window.
# 4. If the hash value of the current window matches the hash value of the needle, check if the characters in the window match the needle.
# 5. If they match, return the starting index of the window.
# 6. If they don't match, continue iterating through the haystack string.    

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Get the lengths of the haystack and needle strings
        m = len(haystack)
        n = len(needle)
        # Define a position factor for the hash value calculation
        posFac = pow(26, n)
        # Define a prime number, that keeps the hash value within range of the prime number
        prime = 10001
        # Initialize the hash value of the needle string
        pHash = 0
        # Calculate the hash value of the needle string
        for c in needle:
            pHash = (pHash * 26 + (ord(c) - ord('a') + 1)) % prime
        # Initialize the hash value of the current window in the haystack string
        currHash = 0
        # Iterate through the haystack string
        for i in range(len(haystack)):
            # Update the hash value of the current window
            currHash = (currHash * 26 + (ord(haystack[i]) - ord('a') + 1)) % prime
            # If the window size exceeds n, remove the character that is sliding out of the window from the hash value
            if i >= n:
                currHash = (currHash - ((ord(haystack[i-n]) - ord('a') + 1) * posFac)) % prime
            # If the hash value becomes negative, add the prime number to keep it positive
            if currHash < 0:
                currHas += prime
            # If the hash value of the current window matches the hash value of the needle string
            if currHash == pHash:
                # Check if the characters in the current window match the needle string
                if i >= n-1 and haystack[i-n+1:i+1] == needle:
                    # If they match, return the starting index of the window
                    return i-n+1
        # If no match is found, return -1
        return -1