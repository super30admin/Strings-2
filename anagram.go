// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a map for p string with its characters and counts
create res array
set match to 0
loop over s
if character exists in map then decrement it from ma and if the value is 0 then increment match
now remove the i-len(p)th index (if valid) from the sliding window
if it exists in map the increment its value and if value is 1 then reduce match by 1
if match == length of map then append i - len(p) + 1 to res
return res
*/
package main

import "fmt"

func findAnagrams(s string, p string) []int {
	m := make(map[byte]int)
	for i:=0;i<len(p);i++ {
		v, e := m[p[i]]
		if e {
			m[p[i]] = v + 1
		} else {
			m[p[i]] = 1
		}
	}
	res := []int{}
	match := 0
	for i:=0;i<len(s);i++ {
		//incoming
		v, e := m[s[i]]
		if e {
			v--
			if v == 0 {
				match++
			}
			m[s[i]] = v
		}

		//outgoing
		if i >= len(p) {
			v1, e1 := m[s[i - len(p)]]
			if e1 {
				v1++
				if v1 == 1 {
					match--
				}
				m[s[i - len(p)]] = v1
			}
		}
		if match == len(m) {
			res = append(res, i - len(p) + 1)
		}
	}
	return res
}

func MainAnagram() {
	fmt.Println(findAnagrams("cbaebabacd", "abc")) //expected [0, 6]
}
