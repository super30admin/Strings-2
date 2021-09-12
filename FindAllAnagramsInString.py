"""
Time Complexity : O(n) + O(max element) 
Space Complexity : O(max element)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or len(p) == 0:
            return []
        result = []
        mapDict = {}
        match = 0
        # Count the frequency of all characters in string p and store it in a map
        for i in p:
            if i in mapDict:
                mapDict[i] += 1
            else:
                mapDict[i] = 1
        # We traverse through string s and increment decrement our window according 
        # to the matches we found and keep count of those.
        for i in range(len(s)):
            # Keeping the count of all the incoming new characters and if it matches 
            # the count in the map we decrement the count and whenever count becomes 
            # 0 we increment the match counter by 1 and update charcter count in map
            if s[i] in mapDict:
                count = mapDict[s[i]]
                count -= 1
                if count == 0:
                    match += 1
                mapDict[s[i]] = count
            # Whenever the size of the window becomes greater than the size of map we
            # remove the character from the begining or move the window. We then 
            # check the outgoing character is in the map. If it is then we get its 
            # count and increment it. We also decrement match and update the count in 
            # the map
            if i >= len(p):
                out = s[i - len(p)]
                if out in mapDict:
                    count = mapDict[out]
                    count += 1
                    if count == 1:
                        match -= 1
                    mapDict[out] = count
            # if the match number matches size of our map we add the resulting index
            # to the final result
            if match == len(mapDict):
                result.append(i - len(p) + 1)
        return result
                
                