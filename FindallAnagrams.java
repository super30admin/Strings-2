
//Time Complexity : O(n+m)
//Space Complexity :O(m) //map size
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
*1. prepare a map for second string with character and its occurrence count
*2. for each character when found in map reduce it's count by 1 and when it is zero you matched once character.in crease *   match by 1.
*3. when sliding window and out character exist in the map increase occurrence count by 1 in the map. when count reached 1 *   decrease match count by 1. meanse we are left one character from previously found string.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindallAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (p == null || p.length() == 0 || p.length() > s.length())
			return result;

		Map<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			countMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			char in = s.charAt(i);
			if (countMap.containsKey(in)) {
				int count = countMap.get(in);
				count--;

				// when all occurence of char found increase match count
				if (count == 0) {
					match++;
				}
				countMap.replace(in, count);
			}

			// out char
			if (i >= p.length()) {
				char out = s.charAt(i - p.length());
				if (countMap.containsKey(out)) {
					int count = countMap.get(out);
					count++;

					if (count == 1) {
						match--;
					}
					countMap.replace(out, count);
				}

			}

			if (match == countMap.size()) {
				result.add(i - p.length() + 1);
			}

		}
		return result;
	}
}