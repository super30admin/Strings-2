// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if needle is "" return 0
if needle is longer than haystack return -1
set i, j to 0
get lps array
loop over haystack with i
if haystack[i] == needle[j] increment i, j and if j==len(needle) return i-len(needle)
else if j > 0 && haystack[i] != needle[j] set j = lps[j-1]
else if j == 0 && haystack[i] != needle[j] increment i

return -1

longestCommonPrefixSuffix function
set j=0, i=1
loop over needle using i
if needle[i] == needle[j] increment j set lps[i]to j, increment i
else if j > 0 && haystack[i] != needle[j] set j = lps[j-1]
else if j == 0 && haystack[i] != needle[j] increment i
return lps
*/
package main

import "fmt"

func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	if len(haystack) < len(needle) {
		return -1
	}
	/*for i:=0;i<len(haystack) - len(needle) + 1;i++ {
	    if needle[0] == haystack[i] {
	        k := i
	        j := 0
	        for k < len(haystack) && needle[j] == haystack[k] {
	            k++
	            j++
	            if j == len(needle) {
	                return i
	            }
	        }
	    }
	}*/

	i := 0
	j := 0
	lps := longestCommonPrefixSuffix(needle)
	for i < len(haystack) {
		if haystack[i] == needle[j] {
			i++
			j++
			if j == len(needle) {
				return i - len(needle)
			}
		} else if j > 0 && haystack[i] != needle[j] {
			j = lps[j-1]
		} else if j == 0 && haystack[i] != needle[j] {
			i++
		}
	}


	return -1
}

func longestCommonPrefixSuffix(needle string) []int {
	j := 0
	i := 1
	lps := make([]int, len(needle))
	for i < len(needle) {
		//case 1
		if needle[i] == needle[j] {
			j++
			lps[i] = j
			i++
		} else if j > 0 && needle[i] != needle[j] {
			j = lps[j-1]
		} else if j == 0 && needle[i] != needle[j] {
			lps[i] = 0
			i++
		}
	}
	return lps
}

func MainStrStr() {
	fmt.Println(strStr("hello", "ll")) //expected 2
}
