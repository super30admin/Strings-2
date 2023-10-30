class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        s1 = needle
        s2 = haystack

        if len(s2) < len(s1):
            return -1

        if s1 not in s2:
            return -1

        for i,s in enumerate(s2):
            if s1[len(s1)-1] == s2[i]:
                ans = (i+1)-len(s1)
                if s1 == s2[ans:i+1]:
                    return ans
        return -1

''' 
Time Comlexity: O(n)
Space Complexity: O(1)
'''