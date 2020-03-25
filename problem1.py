'''
Time Complexity: O(n+m)
Space Complexity: O(1) -> 26 characters
Did this code successfully run on Leetcode : Yes
Explanation: Create a frequency map of all characters ie 26 characters of alphabet and then use it to map all frequencies of p (frequencyP)
After that use sliding window of length of s and add characters seen in the frequencyWindow with (frequencyP) and check if they are same.
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s ) <len(p):
            return []

        frequencyP = [0 ] *26
        frequencyWindow =[0] * 26

        for i in range(0, len(p)):
            ch = p[i]
            frequencyP[ord(ch) - ord('a')] += 1

        res = []
        start = 0
        end = 0
        while end < len(s):
            # print(end)
            ch = s[end]
            frequencyWindow[ord(ch) - ord('a')] += 1

            if end - start + 1 > len(p):
                frequencyWindow[ord(s[start]) - ord('a')] -= 1
                start += 1

            if frequencyWindow == frequencyP:
                res.append(start)

            end += 1

        return res


