#Accepted on leetcode
#Time complexity - O(N) where N is len string
#Space omplexity - O(1) we use hashmap of constant size (worst case-26 letters)

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        #Edge case
        if p == None or s == None:
            return res
        
        _hash = {}
        match = 0
        
        #Insert all the chars in the pattern sting into the hashmap with num of their occurrences as values
        for c in p:
            if c in _hash:
                _hash[c] += 1
            else:
                _hash[c] = 1
        
        for i in range(len(s)):
            #incoming
            c = s[i]
            if c in _hash:
                #If incoming char is in hashmap, then reduce count by 1
                _hash[c] = _hash[c]-1
                if _hash[c] == 0:
                    match += 1#Increase the match by 1
            #Outgoing
            if i >= len(p):
                c = s[i-len(p)]
                if c in _hash:
                    _hash[c] = _hash[c]+1
                    if _hash[c] == 1:
                        match -= 1
            
            if match == len(_hash):
                res.append(i - len(p)+1)
        return res