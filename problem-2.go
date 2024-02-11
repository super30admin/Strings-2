/*time complexity : O(n)
space complexity : O(n)*/


func findAnagrams(s string, p string) []int {
	// Initialize slices to track the count of characters in string p and the current window s
	pCount, sCount := make([]int, 26), make([]int, 26)
	// Slice to store the results
	result := []int{}

	// Populate slices for string p
	for _, ch := range p {
		pCount[ch-'a']++
	}

	// Initialize pointers for the window
	left, right := 0, 0
	for right < len(s) {
		// Add the current character to the window
		sCount[s[right]-'a']++
		// If the size of the window is greater than p, decrement the character count at the left position of the window and shift the left pointer
		if right-left+1 > len(p) {
			sCount[s[left]-'a']--
			left++
		}
		// If the counts for the current window and p are equal, add left to the result
		if right-left+1 == len(p) && compare(pCount, sCount) {
			result = append(result, left)
		}
		right++
	}

	return result
}

// Function to compare two slices
func compare(a, b []int) bool {
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
