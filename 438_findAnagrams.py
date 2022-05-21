# check the char in p? is it from s? 
    # check the next window -- if yes -- index = index + l2 else move to next char
    
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:                
        if s==None or p==None : return []   
        
        result = []
        l1, l2 = len(s) , len(p)
        if l1 < l2: return result 
        p_count, s_count = [0]*26 , [0]*26 
        
        for char in p: 
            p_count[ord(char) - ord('a')] +=1 
                
        i = 0 
        window = s[i:i+l2]
        for char in window:
            s_count[ord(char)-ord('a')] +=1 
            
        if s_count == p_count:
            result.append(i)
        #print(result)
        
        #print(p_count)
        
        i = 1 
        while i < l1-l2+1:
            remove =s[i-1] 
            add = s[i+l2-1] 
            if add!=remove:
                s_count[ord(remove)-ord('a')] -=1
                s_count[ord(add)-ord('a')] +=1 
            if s_count ==p_count: 
                result.append(i)                
            i+=1
            #print(s_count)
        return result 
                