class Solution:
    
    """
    Description: Given a string s and a non-empty string p, find all the start indices of p's anagrams in s
    
    Time Complexity:
    Space Complexity:
    
    Approach: Sliding window
    - maintain a dictionary from patterns with count of each character, and match (initiate with 0)
    - match will be updated to len(p) when anagram is present
    - use a sliding window of size <= len(p), move it across and do the following:
      + increase count of the character by 1 in dictionary if outgoing character is present
      + reduce count of the character by 1 in dictionary if incoming character is present
      + for every instance: if count of a character is either 0 or 1:
        -> increase the match by 1 if count == 0
        -> decrease the match by 1 if count == 1
    - at every iteration, when match == len(p); record the index of outgoing character + 1
    """
    
    def findAnagrams(self, s: str, p: str) -> List[int]:
    
        result = []
        if len(s) < len(p): return result

        p_dict = {}
        for c in p:
            if c in p_dict:
                p_dict[c] += 1
            else: p_dict[c] = 1

        p_dict

        inChar = s[0]; outChar = ""
        match = 0; 

        for i in range(len(s)):

            inChar = s[i]
            if inChar in p_dict:
                p_dict[inChar] -= 1
                if p_dict[inChar] == 0:
                    match += 1

            if i > len(p) - 1: 
                outChar = s[i - len(p)]
                if outChar in p_dict:
                    p_dict[outChar] += 1
                    if p_dict[outChar] == 1:
                        match -= 1

            if match == len(p_dict): result.append(i - len(p) + 1)
                
        return result
            
