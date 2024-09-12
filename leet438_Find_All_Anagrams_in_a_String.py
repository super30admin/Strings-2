# Solution

# // Time Complexity : O(M) where M is the size of String
# // Space Complexity : O(1) since at max there can be just 26 characters
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# We can first put all the characters with respective frequency in a dictionary. Now we can have two indexs, low and high.
# Keep moving high from 0 to n(size of p whose anagram is to be found) and as we move we can reduce the frequency of each
# character from Dictionary. Once all character's frequency is 0, we have an anagram with us between low and high. So save the low
# in result list. Once done, now we can keep moving both low and high character by character. When we are moving the indexes, we
# can increase the frequency of removed character in dictionary, since we are shifting the whole window to the right. If character
# at high is in dictionary then we can reduce the frequency and we can keep moving the window. Since we are having rest of the
# characters between low and high always with in the selected string(window) we always need to just process the low and high

def findAnagrams(s,p):
    # S30
    m = len(s)
    n = len(p)
    if m<n:
        return []
    result = []
    pDict = {}

    for c in p:
        if c in pDict:
            pDict[c] += 1
        else:
            pDict[c] = 1
    
    low = 0
    high = 0
    match = 0
    dictLen = len(pDict)
    while high<n:
        if s[high] in pDict:
            pDict[s[high]] -= 1

            if pDict[s[high]] == 0:
                match += 1
                if match == dictLen:
                    result.append(low)
        
        high += 1

    low += 1

    while low < m and high < m:
        if s[low-1] in pDict:
            if pDict[s[low-1]] == 0:
                match -= 1
            pDict[s[low-1]] += 1
        
        if s[high] in pDict:
            pDict[s[high]] -= 1
            if pDict[s[high]] == 0:
                match += 1
        
        if match == dictLen:
            result.append(low)

        low += 1
        high += 1
    
    return result

# Previous solution
        # if len(s) < len(p):
        #     return []

        # pCount = {}
        # sCount = {}

        # for i in range(0,len(p)):
        #     pCount[p[i]] = 1 + pCount.get(p[i],0)
        #     sCount[s[i]] = 1 + sCount.get(s[i],0)
        
        # res = [0] if pCount == sCount else []

        # for i in range(len(p),len(s)):
        #     sCount[s[i-len(p)]] -= 1
        #     if sCount[s[i-len(p)]] == 0:
        #         sCount.pop(s[i-len(p)])
        #     sCount[s[i]] = 1 + sCount.get(s[i],0)
        #     if sCount == pCount:
        #         res.append(i-len(p)+1)
        
        # return res

if __name__ == "__main__":
    s = "cbaebabacd"
    p = "abc"
    print(findAnagrams(s,p))