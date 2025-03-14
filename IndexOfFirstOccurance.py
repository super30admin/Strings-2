class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        base = 256  # Character set size
        prime = 101  # Prime number for hashing
        m, n = len(needle), len(haystack)
    
        if m > n:
            return -1
    
        needle_hash = sum(ord(needle[i]) * (base ** (m - i - 1)) for i in range(m)) % prime
        window_hash = sum(ord(haystack[i]) * (base ** (m - i - 1)) for i in range(m)) % prime
    
        for i in range(n - m + 1):
            if needle_hash == window_hash and haystack[i:i+m] == needle:
                return i
            if i < n - m:
                window_hash = ((window_hash - ord(haystack[i]) * (base ** (m - 1))) * base + ord(haystack[i + m])) % prime
                window_hash = (window_hash + prime) % prime  # Ensure positive hash
    
        return -1


# m*n time complexity
    '''
        
        length1 = len(haystack)
        length2 = len(needle)
        i=0
        while (i<=length1-length2):
            if haystack[i]==needle[0]:
                k=i
                j=0
                while (haystack[k]==needle[j]):
                    k +=1
                    j +=1
                    if (j == length2):
                        return i
            
            i +=1
        return -1
        '''
