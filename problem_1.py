# TC: O(n)
# SC: O(1)

def strStr(haystack, needle):
    for i in range(len(haystack)):
        if (haystack[i:i+len(needle)] == needle):
            return i
    return -1