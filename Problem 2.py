# Time: O(len(s))
# Space:O(1)
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        dic = {}
        for i in p:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1
        match = 0
        ans = []
        for j in range(len(s)):
            if j >= len(p):
                if s[j-len(p)] in dic:
                    if dic[s[j-len(p)]] == 0:
                        match -= 1
                    dic[s[j-len(p)]] += 1
            if s[j] in dic:
                dic[s[j]] -= 1
                if dic[s[j]] == 0:
                    match += 1
            if match == len(dic):
                ans.append(j-len(p)+1)
            #print(j, dic)
        return ans
                
            
                    
            
        
