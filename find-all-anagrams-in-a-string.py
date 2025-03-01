# tc O(n), sc O(1).
if len(s) < len(p):
    return []
pmap = defaultdict(int)
smap = defaultdict(int)

for i in range(len(p)):
    pmap[p[i]] += 1
    smap[s[i]] += 1

indices = []
if smap == pmap:
    indices.append(0)

for i in range(len(p), len(s)):
    smap[s[i]] += 1
    smap[s[i-len(p)]] -= 1
    if smap[s[i-len(p)]] == 0:
        del smap[s[i-len(p)]]
    
    if smap == pmap:
        indices.append(i-len(p)+1)


return indices