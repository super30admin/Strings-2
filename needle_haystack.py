def computeLPSArray(needle):
    m = len(needle)
    lps = [0] * m
    length = 0  # length of the previous longest prefix suffix
    i = 1

    while i < m:
        if needle[i] == needle[length]:
            length += 1
            lps[i] = length
            i += 1
        else:
            if length != 0:
                length = lps[length - 1]
            else:
                lps[i] = 0
                i += 1
    print(lps)
    return lps

def strStr(haystack: str, needle: str) -> int:
    if not needle:
        return 0
    
    n = len(haystack)
    m = len(needle)

    # Preprocess the needle to get the LPS array
    lps = computeLPSArray(needle)

    i = 0  # index for haystack
    j = 0  # index for needle

    while i < n:
        if needle[j] == haystack[i]:
            i += 1
            j += 1

        if j == m:
            return i - j  # found the needle in haystack, return the starting index

        elif i < n and needle[j] != haystack[i]:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1

    return -1  # needle not found

haystack = "sdjhlwgjwrachjlwj;fw"
needle = "rach"
print(strStr(haystack,needle))

#time complexity = O(N + M)