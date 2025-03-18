# https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for i in range(0,len(haystack)-n+1):
            if haystack[i:i+n] == needle:
                return i
        
        return -1

# TC: O(m * n) m is len of haystack and n is for needle we are slicing everytime so
# SC: O(1)

# rabin karp and KMP are in LC only
################################ rabin karp
'''
def rabin_karp(haystack: str, needle: str) -> int:
    n, m = len(haystack), len(needle)
    if m > n:
        return -1
    
    h = 256  # number of characters in the alphabet

    # Calculate hash values
    p_hash = sum([ord(needle[i]) * pow(h, m - 1 - i, 1000000007) for i in range(m)])
    t_hash = sum([ord(haystack[i]) * pow(h, m - 1 - i, 1000000007) for i in range(m)])
    
    for i in range(n - m + 1):
        # If the hashes match and the substring is equal to the needle, return the starting index
        if p_hash == t_hash and haystack[i:i + m] == needle:
            return i
        
        # Calculate next hash value
        if i < n - m:
            t_hash = (t_hash - ord(haystack[i]) * pow(h, m, 1000000007) + ord(haystack[i + m])) % 1000000007
            if t_hash < 0:
                t_hash += 1000000007

                return -1
            # If the hashes don't match, continue to the next iteration
            elif p_hash != t_hash:
                continue

            # If hashes match, but the substring isn't equal to the needle, continue to the next iteration
            else:
                for j in range(m):
                    if haystack[i + j] != needle[j]:
                        break
                else:
                    return i
                t_hash = (t_hash - ord(haystack[i]) * pow(h, m, 1000000007) + ord(haystack[i + m])) % 1000000007
                if t_hash < 0:
                    t_hash += 1000000007
                    return -1
                continue
            return -1
        
        t_hash = (t_hash - ord(haystack[i]) * pow(h, m, 1000000007) + ord(haystack[i + m])) % 1000000007
        if t_hash < 0:
            t_hash += 1000000007
            return -1
        continue
    return -1

# TC: O(n+m)

'''
