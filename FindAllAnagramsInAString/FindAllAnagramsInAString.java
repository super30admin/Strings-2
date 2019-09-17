package FindAllAnagramsInAString;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//Time Complexity	-	O(mnlogn) m - number of characters in string s
//								  n - number of characters in string p
//Space Complexity	-	O(n) 	  n - number of characters in string p

class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();

		// sort string p
		char[] ch = p.toCharArray();
		Arrays.sort(ch);
		String sorted = new String(ch);

		// For a substring of size p.length, sort the characters in the substring and
		// check if it's equal to the sorted character string of p
		for (int i = 0; i <= s.length() - p.length(); i++) {
			String temp = s.substring(i, i + p.length());
			char[] cha = temp.toCharArray();
			Arrays.sort(cha);
			String target = new String(cha);
			if (sorted.equals(target))
				result.add(i);
		}

		return result;

	}
}