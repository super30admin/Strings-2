#Time Complexity : O(N+M), N and M being the length of the strings. 
#Space Complexity : O(N), N being the length of string p.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug a bit due to small errors.
#Your code here along with comments explaining your approach in three sentences only
'''Create a dictionary for p and a dictionary for length p of s. Whil parsing through
the remainder of s, check if the dictionaries are equal. If they are, add to the result
array. 
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #initialize and take care of the case where s is shorter than p. 
        dict_p={}
        dict_s={}
        result = []
        if len(s)<len(p):
            return result
        #create dictionary for p and initialize dictionary for s. 
        for i in p:
            if i not in dict_p.keys():
                dict_p[i]=1
            else:
                dict_p[i] = dict_p[i]+1
        
        for i in range(len(p)):
            c=s[i]
            if c not in dict_s.keys():
                dict_s[c]=1
            else:
                dict_s[c]=dict_s[c]+1

        #if dictionary p equals dictionary s, add to result 0
        if dict_p==dict_s:
            result.append(0)
        #parse through the remainder of s and add to result if dictionary is equal to the dictionary p.
        for i in range(len(p), len(s)):
            curr=s[i]
            prev=s[i-len(p)]
            if curr not in dict_s.keys():
                dict_s[curr] = 1
            else:
                dict_s[curr] = dict_s[curr]+1
            if dict_s[prev]==1:
                dict_s.pop(prev)
            else:
                dict_s[prev] = dict_s[prev]-1
            if dict_p==dict_s:
                result.append(i-len(p)+1)
        return result