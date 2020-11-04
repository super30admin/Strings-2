# Time Complexity : O(n/m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        output = []
        p_count = collections.Counter(p)
        start, end = 0, len(p)-1
        while end < len(s):
            s_count = collections.Counter(s[start:end+1])
            if s_count == p_count:
                output.append(start)
            start += 1
            end += 1
        
        return output
