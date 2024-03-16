package week7.day7;
//TC - O(n+m)
//SC - O(1)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		int plength = p.length();
		int slength = s.length();
		List<Integer> result = new ArrayList<>();
		if (plength > slength) {
			return result;
		}
		// iterate over p and add it to map
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : p.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int start = 0;
		int end = 0;
		int match = 0;
		while (end < slength) {
			char in = s.charAt(end);
			if (map.containsKey(in)) {
				int old_val = map.get(in); // in
				map.put(in, old_val - 1);
				int new_val = map.get(in);
				if (old_val == 1 && new_val == 0)
					match++;
				else if (old_val == 0 && new_val == 1)
					match--;
			}
			if (match == map.size()) {
				result.add(start);
			}
			if (end < plength - 1)
				end++;
			else {
				char out = s.charAt(start); // out
				if (map.containsKey(out)) {
					int old_val = map.get(out);
					map.put(out, old_val + 1);
					int new_val = map.get(out);
					if (old_val == 1 && new_val == 0)
						match++;
					else if (old_val == 0 && new_val == 1)
						match--;
					if (match == map.size()) {
						result.add(start);
					}
					start++;
					end++;
				}
			}

		}
		return result;
	}
}

public class FindAllAnagramsinStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<Integer> e = s.findAnagrams("cabac", "abc");
		System.out.println(e);
	}

}
