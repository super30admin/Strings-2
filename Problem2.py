# Time Complexity : O(n), where n is the length of the longest string s. 
# Space Complexity :O(26) = O(1) for map
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# ****Step 1: Consider a window of size len of p. For every incoming new character, we decrement 
#               the count in our map and if the character matches then we increment the "match" counter by 1. 
# ****Step 2: For every outgoing character, we need increment the count if its in the map because we are 
#               using the window and for every outgoing character we have already decrement it in step1 
#               else the count in map will go on in minus.
class Solution:
    def findAnagrams(self, s, p):
        result = []
        if len(p) == 0 or len(s) == 0:
            return result 
        
        map_ = {}
        match = 0 
        
        for indx in range(len(p)):              # O(m), where m = len(p)
            if p[indx] not in map_:
                map_[p[indx]] = 1 
            else:
                map_[p[indx]] += 1 
        
        for indx in range(len(s)):              # O(n), where m = len(s)
            # for the incoming character in my window.
            if s[indx] in map_:
                # decrement the count and increment the match variable by 1, as we found a match.
                map_[s[indx]] -= 1 
                if map_[s[indx]] == 0:
                    match += 1 
            
            # For the outgoing character from my window.
            if indx >= len(p):
                out = s[indx - len(p)]
                if out in map_:
                    map_[out] += 1 
                    if map_[out] == 1: # as initially was set to 1.
                        match -= 1
                        
            
            if match == len(map_):
                result.append(indx - len(p) + 1)
        
        return result 


if __name__ == "__main__":
    s = "cbaebabacd"
    p = "abc"
    s1 = Solution()
    
    # Test case 1 : [0, 6]
    res = s1.findAnagrams(s, p)
    print(res)