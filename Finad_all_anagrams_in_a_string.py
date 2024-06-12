# TC - O(M+N)
# SC - O(M) Space taken by dictionary p_map
'''
Basic approach: Search for all substrings, sort it and compare with the small string (sorted again)
Optimized approach: Using hashmap and two pointers, explained in the comments
Time Complexity: O(m+n) , m and n. is the length of string s and p respectively
Space Complexity: O(n) for hashmap
'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        # Anagrams are always equal in length
        
        result = []
        
        #base case
        if len(p)>len(s):
            return result
        
        p_map = {} # to store dictionary hashmap to store chars of p string and its count as values

        
        for char in p:
            if char not in p_map:
                p_map[char]=0
                
            p_map[char]+=1
             
        counter = len(p_map) # how many characters do we need to look for the anagram
        begin = 0
        end = 0
        
        # iterate through string s with start and end pointer
        while(end<len(s)):
            
            ch = s[end]
            
        # End pointer keeps on checking the values in hashmap for incoming characters and decreases the count of corresponding character in hashmap.
            if ch in p_map:
                p_map[ch]-=1
                
                # As soon as the count becomes 0 then the criteria for that character to be
                # present has been satisfied (even in case of multiple occurrences of same character).
                if p_map[ch]==0:
                    counter-=1

            while counter == 0:
                
                temp = s[begin]
                
                # If the character at outgoing start exists in hashmap we need to increment it back
                # as it is moving out of the window.
                if temp in p_map:
                    p_map[temp]+=1
                    
                    if p_map[temp]>0:
                        counter+=1
            # When match is equal to p's length then the current start is a valid index and add to output
                if (end-begin+1)==len(p):
                    result.append(begin)
                # When the substring under consideration crosses the length of smaller string then we
                # increment start pointer    
                begin+=1
                
            end+=1
            
        return result
                