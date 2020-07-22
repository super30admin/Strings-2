class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(M+N) [Size of the strings]
        Space: O(1)
        
    
    """
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        # edge case
        if not s:
            return []
        
        # used prime technique cause the multiplied prime values of the characters of the anagrams will always be unique
        primes_array = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        res = []
        calc = 1
        val = 1
        
        for i in range(len(p)):
            val = val * primes_array[ord(p[i]) - ord("a")]
        
        slow = 0
        fast = 0
        
        # sliding window technique 
        while fast < len(s):
            if fast < len(p):
                calc = calc * primes_array[ord(s[fast]) - ord("a")]
                fast += 1
                if fast == len(p):
                    if calc == val:
                        res.append(slow)
            else:
                calc = calc//primes_array[ord(s[slow]) - ord("a")]
                slow += 1
                calc = calc * primes_array[ord(s[fast]) - ord("a")]
                fast += 1
                
                if calc == val:
                    res.append(slow)
            
        
        return res
            
