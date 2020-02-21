//Time complexity is O(s)
//Space complexity is O(p)
//This solution is submitted on Leetcode

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BigN96FindAllAnagramInAString {
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> result = new ArrayList<>();
			// edge case
			if (s == null || s.length() == 0 || s.length() < p.length())
				return result;
			int match = 0;
			// creating the hashmap
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			for (int i = 0; i < s.length(); i++) {
				// incoming character logic
				char in = s.charAt(i);
				if (map.containsKey(in)) {
					map.put(in, map.get(in) - 1);
					if (map.get(in) == 0)
						match++;
				}
				// outgoing logic
				if (i >= p.length()) {
					char out = s.charAt(i - p.length());
					if (map.containsKey(out)) {
						map.put(out, map.get(out) + 1);
						if (map.get(out) == 1)
							match--;
					}
				}
				if (match == map.size())
					result.add(i - p.length() + 1);
			}
			return result;
		}
	}
}