# I implemented a method to find all starting indices of anagrams of string p in string s by using a sliding window approach with a frequency counter. First, I created a frequency dictionary d to count the occurrences of each character in p. Then, I iterated through the string s while maintaining a sliding window of size equal to the length of p. For each character in the window, I updated the frequency count and adjusted it when the window shifted. The key check was whether all counts in d were zero, indicating that the current window is an anagram of p. The indices of these valid windows were collected and returned. The time complexity of this approach is O(N), where N is the length of s, as each character is processed in constant time. The space complexity is O(M), where M is the length of p, due to the space required for the frequency dictionary.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d = {}
        n = len(p)
        for c in p:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        ans = []
        for i in range(len(s)):
            if s[i] in d:
                d[s[i]] -= 1
            if i >= n and s[i - n] in d:
                d[s[i - n]] += 1
            if False not in [v == 0 for k, v in d.items()]:
                ans.append(i - n + 1)
        return ans