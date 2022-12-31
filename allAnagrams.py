#Time Complexity: O(Ns) where Ns is length of s
#Space Complexity: O(1)
#Did it run on leetcode: Yes

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ns, np = len(s), len(p)
        if ns < np:
            return []

        p_count, s_count = [0] * 26, [0] * 26
        for ch in p:
            p_count[ord(ch) - ord('a')] += 1
        
        output = []
        for i in range(ns):
            s_count[ord(s[i]) - ord('a')] += 1
            if i >= np:
                s_count[ord(s[i - np]) - ord('a')] -= 1
            if p_count == s_count:
                output.append(i - np + 1)
        
        return output