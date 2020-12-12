# Time Complexity:- O(n+p)
# Space Complexity:- O(1)
# Approach:- Anagram of a string means that any other string which has the same count of charachters in it. For eg:- abc is an anagram of acb because both the string have the same count of charachters- a:1
# b:1,c:1. Using that intuition this is only possible if the length of this anagram matches the length of the window we will maintain. Using sliding window and hashmap to maintain the count of the charachters in the window we can solve this problem.
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p):
            return []
        ps=collections.defaultdict(int)
        for i in p:
            ps[i]+=1
        i=0
        j=0
        res=[]
        ss=collections.defaultdict(int)
        while(j<len(s)):
            if j-i<len(p):
                ss[s[j]]+=1
            if j-i>=len(p):
                ss[s[i]]-=1
                if ss[s[i]]==0:
                    del ss[s[i]]
                ss[s[j]]+=1
                i+=1
            if ss==ps:
                res.append(i)
            j+=1
        return res
                