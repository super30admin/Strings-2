# Time Complexity: O(m+n) m to traverse s and n to make the hash map
# Space Complexity: O(1) max 26 chars
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        match = 0
        hash_map = defaultdict(int)
        for ch in p:
            hash_map[ch] += 1
        
        for i in range(len(s)):
            
            # incoming
            in_char = s[i]
            if(in_char in hash_map):
                cnt = hash_map[in_char]
                cnt -=1 
                hash_map[in_char] = cnt
                
                if(cnt == 0):
                    match += 1
                    
            # outgoing
            if(i >= len(p)):
                out_char = s[i-len(p)]
                if(out_char in hash_map):
                    cnt = hash_map[out_char]
                    cnt += 1
                    hash_map[out_char] = cnt
                    if(cnt == 1):
                        match -= 1
            
            if(match == len(hash_map)):
                result.append(i-len(p)+1)
        return result