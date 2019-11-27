'''
Accepted on leetcode(438)
time - O(N) , N - length of s. Space - O(1), as alphabets are only 26.
We use sliding window approach here.
1. Create a hashmap of given pattern p with key as alphabet and value as count of occurance.
2. Iterate over s and check if the alphabet exists in map, and if yes then decrease the count in map. And if value in map == 0 then increase the count in match.
3. Maintain a window of size 'p' and slide the window one character at a time. If previous exited chracter is in map then increase the count of alpha by 1 and if map of char == 1 then decrease the match by 1
4. length of map and match are equal then add the index to result.
'''


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        # edge case
        if s is None or p is None or len(s) == 0 or len(p) == 0:
            return result

        map = {}
        match = 0
        # HashMap of string 'p'
        for c in p:
            if c not in map:
                map[c] = 1
            else:
                map[c] += 1

        for i in range(len(s)):
            c = s[i]
            # incoming into window part
            if c in map:
                map[c] -= 1
                if map[c] == 0: match += 1

            # outgoing in window part
            if i >= len(p):
                c = s[i - len(p)]
                if c in map:
                    map[c] += 1
                    if map[c] == 1: match -= 1

            if match == len(map):
                result.append(i - len(p) + 1)
        return result