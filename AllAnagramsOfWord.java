import java.util.HashMap;
import java.util.*;


//Time Complexity : O(M + N)

//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class AllAnagramsOfWord {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<>();
		if (s.length() == 0 || p.length() == 0 || s.length() < p.length())
			return output;
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : p.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					match++;
				}
			}

			if (i >= p.length()) {
				char out = s.charAt(i - p.length());

				if (map.containsKey(out)) {
					map.put(out, map.get(out) + 1);
					if (map.get(out) == 1) {
						match--;
					}
				}
			}
			if (match == map.size()) {
				output.add(i - p.length() + 1);
			}
		}
		return output;
	}
}
