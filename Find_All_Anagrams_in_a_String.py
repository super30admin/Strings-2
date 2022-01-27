class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        Find All Anagrams in a String
        Time complexity: O(N+M)
        Space Complexity: O(1)
        """
        hash_ = Counter(p)
        final = []
        check = Counter()
        np = len(p)
        
        for i,char in enumerate(s):
            check[char] += 1
            
            if i >= np:
                if check[s[i-np]] == 1:
                    del check[s[i-np]]
                else:
                    check[s[i-np]] -= 1
            if check == hash_:
                final.append(i - np + 1)
        return final
        

            
        return final