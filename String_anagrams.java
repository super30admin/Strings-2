
//TC - O(M + N)
//SC - O(1)
import java.util.*;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		HashMap<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}
		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			char in = s.charAt(i);
			// process for incoming
			if (hmap.containsKey(in)) {
				int count = hmap.get(in) - 1;
				hmap.put(in, count);
				if (count == 0)
					match++;
			}
			if (i >= p.length()) {
				char out = s.charAt(i - p.length());
				if (hmap.containsKey(out)) {
					int count = hmap.get(out) + 1;
					hmap.put(out, count);
					if (count == 1)
						match--;
				}
			}
			if (match == hmap.size())
				result.add(i - p.length() + 1);
		}
		return result;
	}
}