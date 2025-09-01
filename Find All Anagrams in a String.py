#  Time Complexity : O(m + n) 
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We create a hashmap of the count of all elements in string p. We create a substring equal to the length of elements in p. If the match count is not equal to the length of hashmap of p we move forward in the string by one character. We process both the incoming and outgoing character to check if the match count is equal to the length of hashmap of p.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pMap = dict()

        #Step 1: Store the elements of string p in a hashmap
        for i in p:
            if i not in pMap:
                pMap[i] = 0
            pMap[i] += 1
        

        res = []
        match = 0       
        
        #Step 2: Check if the element coming in completes the substring
        for i in range(len(s)):
            c = s[i]
            if c in pMap:
                pMap[c] -= 1
                if pMap[c] == 0:
                    match += 1
            print("Match after 1st iter: ", match)
            #Step 3: Check for the outgoing element     
            if i >= len(p):
                if s[i - len(p)] in pMap:
                    pMap[s[i - len(p)]] += 1
                    if pMap[s[i - len(p)]] == 1:
                        match -= 1
            
            print("Match after 2nd iter: ", match)
            if match == len(pMap):
                res.append(i - len(p) + 1)
        
        return res