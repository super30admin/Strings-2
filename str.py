# Time complexity: O(n * m)
# Space complexity: O(1)

def strStr(haystack, needle):
    if needle == "":
        return 0
    try:
        return haystack.index(needle)
    except ValueError:
        return -1

# RABIN KARP
# Time complexity: O(n + m) on average
# Space complexity: O(1)

def strStr(haystack, needle):
    if not needle:
        return 0
    if len(needle) > len(haystack):
        return -1

    d = 256  
    q = 101  
    needle_hash = 0
    haystack_hash = 0
    h = 1

    # calculate h value, h = d^(M-1) % q
    for _ in range(len(needle) - 1):
        h = (h * d) % q

    for i in range(len(needle)):
        needle_hash = (d * needle_hash + ord(needle[i])) % q
        haystack_hash = (d * haystack_hash + ord(haystack[i])) % q

    for i in range(len(haystack) - len(needle) + 1):
        if needle_hash == haystack_hash:
            for j in range(len(needle)):
                if haystack[i + j] != needle[j]:
                    break
            else:
                return i

        if i < len(haystack) - len(needle):
            haystack_hash = (d * (haystack_hash - ord(haystack[i]) * h) + ord(haystack[i + len(needle)])) % q
            if haystack_hash < 0:
                haystack_hash += q

    return -1
