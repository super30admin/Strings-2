import java.util.HashMap;
import java.util.*;


//Time Complexity : O(M + N)

//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class AllAnagramsOfWord {
	 public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();

    Map<Character, Integer> pCount = new HashMap();
    Map<Character, Integer> sCount = new HashMap();
    // build reference hashmap using string p
    for (char ch : p.toCharArray()) {
      if (pCount.containsKey(ch)) {
        pCount.put(ch, pCount.get(ch) + 1);
      }
      else {
        pCount.put(ch, 1);
      }
    }

    List<Integer> output = new ArrayList();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter 
      // on the right side of the window
      char ch = s.charAt(i);
      if (sCount.containsKey(ch)) {
        sCount.put(ch, sCount.get(ch) + 1);
      }
      else {
        sCount.put(ch, 1);
      }
      // remove one letter 
      // from the left side of the window
      if (i >= np) {
        ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        }
        else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }
      // compare hashmap in the sliding window
      // with the reference hashmap
      if (pCount.equals(sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}
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
