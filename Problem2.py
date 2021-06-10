# time complexity : 0(n)
#space complexity : 0(m)
#approach : sliding window
class Solution(object):
    def findAnagrams(self, s, p):
        
        anag_map = {}
        result = []
        for ch in p :
            if ch in anag_map:
                anag_map[ch] +=1
            else:
                anag_map[ch] = 1
        
        m = len(p)
        n = len(s)
        if m > n :
            return result
        str_map = {}
        
        i = 0
        k = i
        while k< i+m:
            if s[k] in str_map:
                str_map[s[k]] +=1
            else:
                str_map[s[k]] = 1
            k = k +1
        
        
        if str_map == anag_map:
            result.append(i)
        
        str_map[s[0]] -= 1
        if str_map[s[0]] == 0:
            del str_map[s[0]]
        for i in range(1,n-m+1):
            if i != 1:
                str_map[s[i-1]] -= 1
                if str_map[s[i-1]] == 0:
                    del str_map[s[i-1]]
            
            if s[k] in str_map:
                    str_map[s[k]] +=1
            else:
                    str_map[s[k]] = 1
            
            
            if str_map == anag_map:
                result.append(i)
            
            k = k +1
            
            
        return result
        
        
        
        
        
        
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        