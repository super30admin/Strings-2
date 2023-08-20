# Time Complexity: O(n)
# Space ComplexitY: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []

        Pmap = {}
        Smap = {}
        res = []

        # Initialize the frequency maps for the first window of size len(p)
        for i in range(len(p)):
            if p[i] not in Pmap:
                Pmap[p[i]] = 1
            else:
                Pmap[p[i]] += 1

            if s[i] not in Smap:
                Smap[s[i]] = 1
            else:
                Smap[s[i]] += 1

        # Check if the first window is an anagram and add its index to 'res'
        if Pmap == Smap:
            res.append(0)

        # Slide the window and update the frequency map for each character
        for i in range(len(p), len(s)):
            # Remove the leftmost character from the window
            if Smap[s[i - len(p)]] == 1:
                del Smap[s[i - len(p)]]
            else:
                Smap[s[i - len(p)]] -= 1

            # Add the current character to the window
            if s[i] not in Smap:
                Smap[s[i]] = 1
            else:
                Smap[s[i]] += 1

            # Check if the current window is an anagram and add its index to 'res'
            if Pmap == Smap:
                res.append(i - len(p) + 1)

        return res
