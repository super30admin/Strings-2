class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        length = len(p)
        setp={}
        result =[]
        window={}
        for i in p:
            setp[i] = setp.get(i,0)+1
        for char in range(len(s)):
            window[s[char]]= window.get(s[char],0)+1

            if (char>=length):
                if(window[s[char-length]]==1):
                    del window[s[char-length]]
                else:
                    window[s[char-length]] -= 1
            
            if setp==window:
                result.append(char-length+1)
        return result