
// approach: brute force
// check each haystack[i:i+len(needle)] substr and compare with needle
// if it matches, great, return i
// otherwise let the for loop increment i and check the next haystack substr
// m = len(needle)
// n = len(haystack)
// time = o(nm)
// space = o(1)
func strStr(haystack string, needle string) int {
    if len(needle) > len(haystack) {
        return -1 // no way a bigger word can exist in a smaller word
    }
    if len(needle) == 0 {return 0}
    for i := 0; i < len(haystack)+1-len(needle); i++ {
        if string(haystack[i:i+len(needle)]) == needle {
            return i
        }
    }
    return -1
}
