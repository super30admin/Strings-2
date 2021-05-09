from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if not s:
            return []
                
        counter = Counter(p)
        #print (counter)
        match = 0
        result = []
        for i in range(len(s)):
            #incoming character
            if s[i] in counter:
                count = counter[s[i]]
                count -=1
                counter[s[i]] = count
                
                if counter[s[i]]==0:
                    match +=1
            #print (counter)
            #ountgoing character        
            if i >= len(p):
                out_char = s[i-len(p)]
                if out_char in counter:
                    count = counter[out_char]
                    count +=1
                    counter[out_char] = count
                    if count == 1:
                        match -=1
            #print(match)
            if match == len(counter):
                result.append(i-len(p) +1)
                
        return result
                    
                
                
