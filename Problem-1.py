#Approach
# consider robin karp's rolling hash. Sine we tahe normal prime number hashing the value of the anagrams will be same.

#Complexities
#Time : O(N+M)
#Space: O(1)


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needleHash = 0

        for char in needle:
            needleHash = (26 * needleHash) + (ord(char) - ord('a') + 1)

        rollingHash = 0
        for i in range(len(haystack)):
            rollingHash = 26 * rollingHash + (ord(haystack[i]) - ord('a') + 1)
            if i >= len(needle):
                rollingHash = rollingHash - (26 ** (len(needle)) * (ord(haystack[i - len(needle)]) - ord('a') + 1))

            if rollingHash == needleHash:
                return i - len(needle) + 1

        return -1


s = Solution()
print(s.strStr("sadbutsad","sad"))