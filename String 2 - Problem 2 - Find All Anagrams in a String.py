"""
FAANMG Problem #99 {Medium} 

438. Find All Anagrams in a String

Time complexity : O(n)
Space complexity : O(1)

        
Did this code successfully run on Leetcode : Yes

Approach --
1. Use hmap to store p string chars. And their occurrences in p string as value
2. Use slow pointer at idx 0. If the char in hmap, increment fast pointer.
While traversing s, incerment the fast pointer, every time a char from hmap is found, decrement it's value from hmap
3. Maintain a match variable to keep track of the length of the anagram being formed. Increment char every time a chars
value in hamap becomes 0
4. if a character in 's' is found which is not in p, move the slow pointer by 1 and increment the value of that char in
hmap
This indicates, to form the next anagram, this curr outgoing char is required
5. For outgoing chars, decrement the count of char when count == 1

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        result=[]
        
        hashmap = {}
        
        # make the frequency count of the pattern string
        for ch in p:
            hashmap[ch] = 1 +hashmap.get(ch,0)
            
        match = 0
        
        # traverse over the s string to check for possible matches
        for idx in range(len(s)):
            ch = s[idx]
            
            #incoming
            # for the incoming character, we decrement the count from freq map and increment the match count if freq is 0
            if ch in hashmap:
                count = hashmap[ch]
                count -=1
                
                if count ==0:
                    match +=1
                hashmap[ch] = count
            
            #outgoing
            # for outgoing character, we restore the freq in map and reduce the match count only if the count becomes 1
            if idx >= len(p):
                out_ch = s[idx - len(p)]
                
                if out_ch in hashmap:
                    count = hashmap[out_ch]
                    count +=1

                    if count ==1:
                        match -=1
                    hashmap[out_ch] = count
            
             # append the starting index to res only if the match count equals the size of Hashmap
            if match == len(hashmap):
                result.append(idx - len(p) +1)
                    
        return result
                
            
        