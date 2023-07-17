# Time complexity: O((len_h - len_n + 1) * len_n), where len_h is the length of haystack and len_n is the length of needle.
# Space complexity: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Helper function to calculate the hash value of a string
        def get_hash(s: str, length: int) -> int:
            h = 0
            k = 31  # Use a prime number as the multiplier
            for i in range(length):
                h = h * k + (ord(s[i]) - ord('a') + 1)
            return h

        len_h = len(haystack) # Get the length of the haystack string
        len_n = len(needle)   # Get the length of the needle string
        if len_h < len_n:     # If haystack is shorter than the needle, return -1
            return -1
        
        # Calculate the hash value of the needle and the initial window in the haystack
        needlehash = get_hash(needle, len_n)
        currhash = get_hash(haystack, len_n)
        
        for i in range(len_h - len_n + 1):  # Iterate through the haystack with a sliding window
            if currhash == needlehash:     # If the current window hash matches the needle hash, return the starting index
                return i

            if i + len_n < len_h:          # If the end of the window is still within the haystack
                # Update the current hash value for the next window
                currhash = currhash * 31 - (ord(haystack[i]) - ord('a') + 1) * 31 ** len_n + (ord(haystack[i + len_n]) - ord('a') + 1)

        return -1  # If the needle is not found in the haystack, return -1
