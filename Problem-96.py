# leetcode - Find All Anagrams in a String - 438 - https://leetcode.com/problems/find-all-anagrams-in-a-string/
# Time complexity - O(N) 
#space complexity -O(1)
# Approach - First we store the count of all letters of a given  pattern in hashmap and then we will have a sliding window of length as pattern and we will traverse through string s. we will have incoming and outgoing loops. 
#incoming : if c in map, reduce count by 1 and if count is 0, we increase the match count
#outgoing : we the c in map, then we increment the count and if count becomes 1, then we decrementclass Solution(object):




class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res=[]
        if not p or not s: return res
        
        hash={}
        
        match=0
        for c in p: #pattern string
            if c in hash:
                hash[c]+=1
            else:
                hash[c]=1
        
       
        for i in range(len(s)):
            #incoming window
            c=s[i]
            if c in hash:
                hash[c]=hash[c]-1
                if hash[c]==0:
                    match=match+1
                
             #outgoing window
            if i>=len(p):
                c=s[i-len(p)]
                if c in hash:
                    hash[c]=hash[c]+1
                    if hash[c]==1:
                        match=match-1
                        
            if match==len(hash):
                res.append(i-len(p)+1)
        return res
            
                
        
        