#Time complexity: O(m+n)   -m is len(p),n is len(s).to put elements in hashmap-O(m) and to traverse S- O(n)
#Space complexity: O(1)-constant space since hashmap can have maz 26 keys-26 alphabets
# Approach: first put the count of each elements in p to a hashmap
# then traverse the string S
# have in and put pointer.
# the in pointer char's count will decrease in hashmap, while out's count will increase in hashmap since its eliminated from substring.
# during in operation, if the count is 0 that means there is a complete match of an alphabet,so we increase match by 1
# during out operation, since we are eliminating an object and if the count of out is 1 after eliminating, that means we now require that alphabet.
# that means match should decrease by 1
# check for match, if match is equal to the length of p, then append the i-len(p)+1 index to result.
# that is the starting idex of substring
# return the list of indices


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s == None or len(s)== 0 or len(s) < len(p):
            return []
        map = dict()
        for char in p:
            if char in map:
                map[char] = map[char]+1
            else:
                map[char] = 1
        result = []
        match = 0
        for i in range(0,len(s)):
            inp = s[i]
            if inp in map:
                count = map[inp]
                count -= 1
                if count == 0:
                    match += 1
                map[inp]=count
            if i >= len(p):
                out = s[i-len(p)]
                if out in map:
                    count = map[out]
                    count += 1
                    if count == 1:
                        match -= 1
                    map[out]= count
            if match == len(map):
                result.append(i-len(p)+1)
        return result
                
            
        