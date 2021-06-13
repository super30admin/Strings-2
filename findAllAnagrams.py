class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s is None:
            return None
        
        dataStore = dict()
        result = []
        match = 0
        for i in p:
            if i not in dataStore:
                dataStore[i]=0
            dataStore[i]+=1
        #incoming
        for i in range(len(s)):
            incoming = s[i]
            if incoming in dataStore:
                count = dataStore[incoming]
                count -= 1
                dataStore[incoming] = count 
                if count == 0:
                    match +=1
                
            
            if i>=len(p):
                
                outgoing = s[i-len(p)]
                if outgoing in dataStore:
                
                    cnt = dataStore[outgoing]
                    cnt += 1
                    dataStore[outgoing] = cnt
                    if cnt == 1:
                        match -=1
            
            if match == len(dataStore):
                result.append(i-len(p)+1)
        
        return result
            
            
                
                
        
