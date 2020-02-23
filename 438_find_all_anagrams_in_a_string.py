from collections import Counter
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
            https://leetcode.com/problems/find-all-anagrams-in-a-string/
            Time Complexity - O(n + m)
                'n' is the length of 'p', time taken to create dictionary.
                'm' is the length of 's', time taken to iterate over it.
            Space Complexity - O(n)
        """
        result = []
        # edge case
        if not s or len(s) < len(p):
            return result
        # hash map char and count
        dic = Counter(p)
        match = 0
        for i in range(len(s)):
            # outgoing char from dic -> reduce our count
            out_char = s[i]
            if out_char in dic:
                dic[out_char] -= 1
                # all count for this char found, increase match
                if dic[out_char] == 0:
                    match += 1
            # incoming char to dic -> adding to our count
            if i >= len(p):
                in_char = s[i - len(p)]
                if in_char in dic:
                    dic[in_char] += 1
                    # if it becomes 1 from 0 we have lost perfect match for that char
                    if dic[in_char] >= 1:
                        match -= 1
            if match == len(dic):
                result.append(i - len(p) + 1)
        return result

    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        pCounter = Counter(p)
        sCounter = Counter(s[:len(p) - 1])
        for i in range(len(p) - 1, len(s)):
            sCounter[s[i]] += 1  # include a new char in the window
            if sCounter == pCounter:  # This step is O(1), since there are at most 26 English letters
                res.append(i - len(p) + 1)  # append the starting index
            sCounter[s[i - len(p) + 1]] -= 1  # decrease the count of oldest char in the window
            if sCounter[s[i - len(p) + 1]] == 0:
                del sCounter[s[i - len(p) + 1]]  # remove the count if it is 0
        return res


if __name__ == '__main__':
    print(Solution().findAnagrams('cabaebabacd', 'aabc'))
