#Time - O(N)
#space- O(P) size of pattern or it can be a max of 26 characters- O(26)
# using sliding window, hashmap and count


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        dic = {}
        
        for i in p:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        
        i = 0 #left
        j = 0 #right
        result = []
        count = len(p)
        
        
        while j < len(s):
            
            if s[j] in dic:
                dic[s[j]] -= 1
                if dic[s[j]] >=0:
                    count -= 1
                
            if count == 0:
                result.append(i)
                
            
            if j - i == len(p)-1:
                if s[i] in dic:
                    if dic[s[i]] >= 0:
                        count += 1
                    
                    dic[s[i]] += 1
                i+=1
            j+=1
        return result
            
