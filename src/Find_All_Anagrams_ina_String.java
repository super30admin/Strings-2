import java.util.*;
/****************************************Brute Force*****************************************/
//Time Complexity :O(m * n log (m*n))
//Space Complexity : O(m)
//Did this code successfully run on Leetcode : Time Limit Exceeded
//Any problem you faced while coding this : No

class Find_All_Anagrams_ina_String_Brute_Force   {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int m = s.length(); int n= p.length();
		for(int i=0; i<= (m-n); i++){
			String subString = s.substring(i, i+n);
			if(checkAnagrams(subString, p)){
				result.add(i);
			}
		}
		return result;
	}
	private boolean checkAnagrams(String s, String p){
		if(s.length() != p.length())
			return false;
		char[] str1 = s.toCharArray();
		char[] str2 = p.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}
}

/****************************************Sliding Window*****************************************/
//Time Complexity : O(m + n), length of strings
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

/**Using Sliding window concept, For every incoming character, decrease its count of occurrence from map
 * for every outgoing character, increase its count of occurrence from the map
 * for the window, where all the pattern's characters' counts are 0, it means the pattern's anagram is found**/

class Find_All_Anagrams_ina_String_Sliding_window {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		int match = 0;
		for(int i=0; i<p.length(); i++){
			char c = p.charAt(i);
			map.put(c, map.getOrDefault(c, 0) +1);    //adding frequency for each character
		}
		for(int i=0; i<s.length(); i++){
			char in = s.charAt(i);  //incoming character
			if(map.containsKey(in)){
				int count = map.get(in);    
				count --;    //reduce the count, if character found
				map.put(in, count);     //updating the count

				if(count == 0)  //when count becomes zero, there is match
					match++;
			}

			//outgoing
			if(i >= p.length()){
				char out = s.charAt(i - p.length());
				if(map.containsKey(out)){
					int count = map.get(out);
					count++;    // increasing count for outgoing character
					map.put(out, count);

					if(count == 1)
						match--;    //if counts is 1, then decrease match
				}
			}

			if(match == map.size()) //if match becomes equal to number of unique characters of p
				result.add(i - p.length() +1);  // add the start index of window to result
		}
		return result;
	}
}

/****************************************Two pointer*****************************************/
//Time Complexity : O(m + n), length of strings
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

/**Same as above, but using slow and fast pointers**/

class Find_All_Anagrams_ina_String_Two_pointer {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		int match = 0;
		for(int i=0; i<p.length(); i++){
			char c = p.charAt(i);
			map.put(c, map.getOrDefault(c, 0) +1);    //adding frequency for each character
		}
		int slow = 0, fast = 0;

		while(fast < s.length()){
			char in = s.charAt(fast);
			if(map.containsKey(in)){
				int count = map.get(in);    
				count --;    //reduce the count, if character found
				map.put(in, count);     //updating the count

				if(count == 0)  //when count becomes zero, there is match
					match++;
			}

			if(fast >= p.length()){
				char out = s.charAt(slow);
				if(map.containsKey(out)){
					int count = map.get(out);
					count++;    // increasing count for outgoing character
					map.put(out, count);

					if(count == 1)
						match--;    //if counts is 1, then decrease match
				}
				slow++;
			}
			if(match == map.size())
				result.add(slow);

			fast++;
		}
		return result;
	}
}