class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []
        result = []
        match = 0
        hashmap = dict()

        for i in range(len(p)):
            c = p[i]
            if c not in hashmap:
                hashmap[c] = 1
            else:
                hashmap[c]  += 1
            
            #in
        for i in range(len(s)):
            inc = s[i]
            print(inc)
            if inc in hashmap:
                count = hashmap[inc]
                count = count - 1
                if count == 0:
                    match = match + 1
                hashmap[inc] = count
                
                #out
            if i >= len(p):
                out = s[i - len(p)]
                if out in hashmap:
                    count = hashmap[out]
                    count = count + 1
                    if count == 1:
                        match = match -1
                    hashmap[out] = count

            if match == len(hashmap):
                result.append(i-len(p)+1)
        return result

            
        