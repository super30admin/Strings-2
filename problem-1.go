/*time complexity : O(n)
space complexity : O(1)
Leet : Ran successfully in leetCode*/

func strStr(haystack string, needle string) int {
	lenNeedle := len(needle)
	lenHaystack := len(haystack)
	for i := 0; i <= lenHaystack-lenNeedle; i++ {
		if haystack[i:i+lenNeedle] == needle {
			return i
		}
	}
	return -1
}
