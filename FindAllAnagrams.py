#TC:  O(n + k)
#SC: O(1)

class FindAllAnagrams:

    #   Function to compare two frequency tables and check for anagrams
    def __checkAnagrams(self, freq1: List[int], freq2: List[int]) -> bool:
        
        for i in range(26):
            if freq1[i] != freq2[i]:
                return False
            
        return True
    
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        #   edge case check
        if (s == None or len(s) == 0 or len(p) > len(s)):
            return []
        
        #   initializations
        freqSubS = [0 for i in range(26)]
        freqP = [0 for i in range(26)]
        
        #   fill frequency array for pattern which is constant throughout
        for i in range(len(p)):
            index = ord(p[i]) - ord('a')
            freqP[index] += 1
            
        #   fill frequency array for first substring of equal length of pattern
        for i in range(len(p)):
            index = ord(s[i]) - ord('a')
            freqSubS[index] += 1
            
        #   initialize resultant array
        result = []
        
        for i in range(1, len(s) - len(p) + 2):
            #   check for anagrams for each index and if yes, add the index to the resultant array
            if (self.__checkAnagrams(freqSubS, freqP) ):
                result.append(i - 1)
            
            #   update the frequency of first index and last index for the new substring
            prevIndex = ord(s[i - 1]) - ord('a')
            freqSubS[prevIndex] -= 1
            
            if (i + len(p) - 1 < len(s)):
                lastIndex = ord(s[i + len(p) - 1]) - ord('a')
                freqSubS[lastIndex] += 1
           
        #   return the resultant array 
        return result
            
            