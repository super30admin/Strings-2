# time complexity : O(NL) where N is len of haysatck l is len of needle
# space complexity : O(n) dp array 
# runs on leetcode : YES
# any problem faced : No
# KMP
def strStr(self, haystack: str, needle: str) -> int:
	if needle == '' and haystack is not None: return 0
	dp = [0] * len(needle)
	for i in range(1, len(needle)):
		j = dp[i-1]
		while j > 0 and needle[j] != needle[i]:
			j = dp[j-1]
		if needle[j] == needle[i]:
			dp[i] = j + 1

	j = 0  # next character to match
	for i, ch in enumerate(haystack):
		while j > 0 and needle[j] != ch:
			j = dp[j-1]

		if needle[j] == ch:
			j += 1
			if j == len(needle): 
				return i-j+1

	return -1