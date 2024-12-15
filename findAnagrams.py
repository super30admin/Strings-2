"""
Get the freq map of string P
Iterate through string S, whenever the slideing window size equals to string P length , check if the frq count of s & p are equal, 
if yes, add starting index of the window to result. shrink window by reducing the freq count of char in the left index and incrementing the index. 
TC: O(s)
SP: o(1) At max hmap will have 26 characters

"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        count_p = Counter(p)
        res = []
        l = 0
        k = len(p)
        count_s = Counter()
        for r in range(len(s)):
            count_s[s[r]]+=1
            if r-l+1>=k:
                if count_s == count_p:
                    res.append(l)
                count_s[s[l]]-=1
                if count_s[s[l]]==0:
                    del count_s[s[l]]
                l+=1
        return res
       