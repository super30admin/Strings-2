# Time Complxity o(N)
# Space cOMPLEXITY O(m)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        hmap = {}
        result = []
#      Put all the characters in p into an hashmap and count their characters
        for a in p :
            
            if a in hmap:
                hmap[a] +=1
            else:
                hmap[a] = 1
        
        match = 0
        
        for a in range(len(s)):
#        Getting the incoming character into the window     
            inc = s[a]
#        If the character is in the hmap . Decrease its count
# If count becomes zero it means that we have found enough of one character ,so increase the matches count
            if inc in hmap:
                count = hmap[s[a]]
                count -=1
                if count ==0 :
                    match +=1
                hmap[s[a]] = count
#            Accessing the outgoing character, The below line of code gives access to the left bound of the window.
#Increase the count in hmap whenever a character leaves the window
# If count increases to once decrease the matches variable count
            if a >= len(p):       
                out = s[a - len(p)]
                if out in hmap:
                    count = hmap[out]
                    
                    count +=1
                    
                    if count == 1:
                        match -=1
                    hmap[out] = count
            
            if match == len(hmap):
                
                result.append(a - len(p) +1)
        
        return result
                    
                    