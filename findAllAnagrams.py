'''
Time Complexity --> O(n)
Space Complexity -->O(1)
'''
from collections import Counter
class Solution:
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        result = []
        length_s = len(s)
        length_p = len(p)
        left = 0
        counter_p = Counter(p)
        counter_s = Counter(s[0:length_p])
        while left <= length_s - length_p:
            right = left + length_p
            if counter_s == counter_p:
                result.append(left)
            if right == length_s:
                break
            counter_s[s[right]] += 1
            
            counter_s[s[left]] -= 1
            if counter_s[s[left]] == 0:
                del counter_s[s[left]]
            left += 1
            
        return result