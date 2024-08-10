from collections import Counter

def findAnagrams(s,p):
    res = []

    len_p = len(p)
    print(len_p)
    p_count = Counter(p)
    #print(p_count)
    s_count = Counter()
    for i in range(len(s)):
        s_count[s[i]] += 1
        print(s_count)

        if i>=len_p:
            if s_count[s[i-len_p]] == 1:
                del s_count[s[i-len_p]]
            else:
                s_count[s[i - len_p]] -= 1
        if s_count == p_count:
            res.append(i-len_p+1)
    return res

s = "cbaebabacd"
p = "abc"
print(findAnagrams(s,p))


#time= O(N)
#space = O(1)