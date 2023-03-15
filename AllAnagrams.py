#All TC passed on leetcode


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        #Here we use sliding window technique. p's chars and their count are stored in map. we traverse s, by shifting j by 1 position to right and i by 1 positing to right, i.e. we delete ith char and add jth char. If cur jth char is in map then we decrement it by 1, if it becomes 0 then 1 match is formed. Similarly if cur ith char is in map then we increment it by 1, it it becomes 1 then -1 match is formed.
        #Time complexity - O(n+m) => O(n) as len of m is lessser than or equal to m. Here n is length of s string and m is length of p string
        #Space complexity - O(1) - as dict holds max 26 chars

        if len(p)>len(s):
            return []

        p_dict = collections.defaultdict(int)

        for ch in p:
            p_dict[ch]+=1
        
        res = []
        i=0
        match = 0
        for j in range(len(s)):

            in_char = s[j]
            if in_char in p_dict:
                p_dict[in_char]-=1
                if p_dict[in_char]==0:
                    match+=1
            
            if (j-i==len(p)):
                out_char = s[i]
                if out_char in p_dict:
                    p_dict[out_char]+=1
                    if p_dict[out_char]==1:
                        match-=1
                i+=1
            
            if len(p_dict)==match:
                res.append(i)
          
        return res
            
  

        

        