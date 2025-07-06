#Time Complexity:O(N)
#Space Complexity: O(1)
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        from collections import defaultdict

        hash_map = {}
        for char in p:
            hash_map[char] = hash_map.get(char, 0) + 1

        res = []
        window_count = defaultdict(int)
        p1, p2 = 0, 0
        required_length = len(p)

        while p2 < len(s):
            char = s[p2]
            window_count[char] += 1
            p2 += 1

            # Keep window size equal to len(p)
            if p2 - p1 == required_length:
                # If the frequency maps match, it's an anagram
                if window_count == hash_map:
                    res.append(p1)

                # Shrink window from the left
                left_char = s[p1]
                window_count[left_char] -= 1
                if window_count[left_char] == 0:
                    del window_count[left_char]
                p1 += 1

        return res