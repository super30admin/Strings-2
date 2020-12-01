class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        start = 0
        pattern_freq = collections.Counter(p)
        match = 0
        result = []
        
        for end in range(len(s)):
            end_char = s[end]
            if end_char in pattern_freq:
                pattern_freq[end_char] -= 1
                if pattern_freq[end_char] == 0:
                    match += 1
                    
            if end - start + 1 > len(p):
                start_char = s[start]
                start += 1
                if start_char in pattern_freq:
                    if pattern_freq[start_char] == 0:
                        match -= 1
                    pattern_freq[start_char] += 1
                    
            if len(pattern_freq) == match:
                result.append(start)
                
        return result