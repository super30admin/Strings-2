import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Time Complexity : O(M)
//Space Complexity : O(K) where k is the set of unique characters. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put p in a map. Then start iterating the s. At each char, put it in the map
 * with its count. at each iteration, check if both maps are equal. If so, add
 * the starting index (i-n+1) to the answer. When the index crosses length of p
 * in s, then remove the leftmost character from it. return the ans.
 *
 */
class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		int m = s.length(), n = p.length();
		List<Integer> ans = new ArrayList<>();
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> pMap = new HashMap<>();
		for (int i = 0; i < n; i++)
			pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);

		for (int i = 0; i < m; i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);

			if (i >= n) {
				char c = s.charAt(i - n);
				sMap.put(c, sMap.get(c) - 1);
				sMap.remove(c, 0);
			}

			if (sMap.equals(pMap)) {
				ans.add(i - n + 1);
			}
		}
		return ans;
	}
}