# Time Complexity : O(n)
# Space Complexity : O(1)

# Approach 1: Sliding Window
# 1. Create a frequency map of characters in p.
# 2. Iterate through s with a sliding window of size n (length of p).
# 3. For each character in s, check if it is in the frequency map.
# 4. If it is, decrement its frequency in the map.
# 5. If the frequency becomes zero, increment a count. This indicates that we have found one of the characters in p, along with its frequency.
# 6. If the window size exceeds n, remove the character that is sliding out of the window from the frequency map and increment the count.
# If its frequency becomes one, decrement the count. This indicates that we have lost one of the characters in p.
# 7. If the count equals the size of the frequency map, it means we have found an anagram of p in s.
# 8. Add the starting index of the window to the result list.
# 9. Continue until the end of s.

class Solution:
    def findAnagrams(self, s: str, p: str):
        # Initialize a frequency map for characters in p
        freq = {}
        # Get the lengths of s and p
        m = len(s)
        n = len(p)
        # Initialize a list to store the result
        res = []
        # Update the frequency map with characters from p
        for c in p:
            freq[c] = 1 + freq.get(c, 0)
        
        i = 0
        # Initialize a count to track the number of unique characters in p
        count = 0
        # Iterate through s with a sliding window
        while i < m:
            # Get the current character in s
            inChar = s[i]
            # If the character is in the frequency map, decrement its frequency
            if inChar in freq:
                f = freq[inChar]
                f -= 1
                # If the frequency becomes zero, increment the count
                freq[s[i]] = f
                if f == 0:
                    count += 1
            # If the window size exceeds n, remove the character that is sliding out of the window from the frequency map
            if i >= n:
                # Get the character that is sliding out of the window
                outChar = s[i-n]
                # If the character is in the frequency map, increment its frequency
                if outChar in freq:
                    f = freq[outChar]
                    f += 1
                    freq[outChar] = f
                    # If the frequency becomes one, decrement the count
                    if f == 1:
                        count -= 1
            # When the count of matching characters equals the size of the frequency map, it means we have found an anagram of p in s
            if count == len(freq):
                # Add the starting index of the window to the result list
                res.append(i-n+1)
            # Move the window forward
            i += 1
        # Return the result list
        return res
    
# Time Complexity : O(n!) + O(n*m), where n is the length of p and m is the length of s.
# Space Complexity : O(n!)
# Did this code run successfully on Leetcode? : No, Time Limit Exceeded

# Approach 2: DFS
# 1. Create a set to store all possible anagrams of p.
# 2. Use a recursive function to generate all permutations of p.
# 3. For each permutation, add it to the set.
# 4. Iterate through s and check if the substring of length n (length of p) is in the set of anagrams.
# 5. If it is, add the starting index of the substring to the result list.
# 6. Continue until the end of s.
class Solution:
    def findAnagrams(self, s: str, p: str):
        # Check if the length of p is greater than the length of s
        if len(p) > len(s):
            # If it is, s cannot contain any anagrams of p. So return an empty list
            return []
        # Create a set to store all possible anagrams of p
        anagrams = set()
        # Get the length of p
        n = len(p)
        # Create a recursive function to generate all permutations of p
        # The function takes two arguments: the string to permute and the current permutation
        def dfs(string, perm):
            # Base case
            # If the string is empty, add the current permutation to the set of anagrams
            if not string:
                anagrams.add(perm)
                return
            # Iterate through the string
            # For each character in the string, remove it from the string and add it to the current permutation
            # Then call the function recursively with the updated string and permutation
            for i in range(len(string)):
                dfs(string[:i]+string[i+1:], perm+string[i])
        # Call the recursive function with the string p and an empty permutation
        dfs(p, '')
        # Initialize a list to store the result
        res = []
        # Iterate through s
        # For each index in s, check if the substring of length n (length of p) is in the set of anagrams
        # If it is, add the starting index of the substring to the result list
        for i in range(len(s)):
            if i >= n-1:
                if s[i-n+1 : i+1] in anagrams:
                    res.append(i-n+1)
        # Return the result list
        return res