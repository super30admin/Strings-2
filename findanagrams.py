# TC = O(m+n), SC = O(1)
''' Create a dictionary to store the frequency of each character in p.
  Initialize a sliding window on s of size len(p), and create a dictionary to store the frequency of characters in the current window.
  Slide the window over s: Add the new character to s_count, Remove the character that is no longer in the window from s_count.
  Compare p_count with s_count to check if the current window is an anagram.
  If both map counts are equal, record the starting index of the window.
  Return the list of starting indices.
'''
def findAnagrams(self, s, p):
    """
    :type s: str
    :type p: str
    :rtype: List[int]
    """
    n = len(p)
    p_map = defaultdict()
    ans = []
    for letter in p:
        p_map[letter] = p_map.get(letter, 0) + 1

    p_map = sorted(p_map.items())

    currWindow = []
    currLen = 0
    currDict = defaultdict()
    left = 0
    for right in range(len(s)):
        c = s[right]
        currWindow.append(c)
        currLen +=1
        currDict[c] = currDict.get(c,0)+1

        while(currLen > n):
            currWindow.remove(s[left])
            if s[left] in currDict:
                if currDict[s[left]] == 1:
                    currDict.pop(s[left])
                else:
                    currDict[s[left]] -=1
            left+=1
            currLen -=1
        
        #check if it is an anagram
        if currLen == n:
            sortedDict = sorted(currDict.items())
            if sortedDict == p_map:
                ans.append(right - n + 1)

    return ans