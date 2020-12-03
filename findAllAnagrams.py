class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ns, np = len(s), len(p)
        
        
        if ns<np:
            return []
        sarr, parr = [0]*26, [0]*26
        output = []
        for i in range(np):
            parr[ord(p[i])-ord('a')]+=1
            
        for i in range(ns):
            sarr[ord(s[i])-ord('a')]+=1
            
            if i>=np:
                sarr[ord(s[i-np])-ord('a')]-=1
            
            if sarr == parr:
                output.append(i-np+1)
        return output

Time Complexity: O(np+np)
Space: O(1)
