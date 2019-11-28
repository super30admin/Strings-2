package demo;

import java.util.*;

//	Time:  
//	Space O(n) map
//	LeetCode: no
class Solution2 {
	List<Integer> result = new ArrayList<>();
	Map<Character,Integer> map = new HashMap<Character, Integer>();

	public List<Integer> findAnagrams(String s, String p) {
		int match=0;
		if(s.length() == 0 || s == null || p.length() ==0 || p == null) return result;

		for(int i=0 ; i < p.length(); i++){
			char c = p.charAt(i);
			if(!map.containsKey(c)){
				map.put(c,i);
			}else{
				map.put(c, map.get(c)+1);
			}
		}
		for(int i=0 ; i < s.length(); i++){
			char incomingChar = s.charAt(i);
			//incoming
			if(map.containsKey(incomingChar)){
				map.put(incomingChar, map.get(incomingChar)-1);
				if(map.get(incomingChar) == 0) match++;
			}
			if(i >= p.length()){
				char outgngChar = s.charAt(i - p.length());
				if(map.containsKey(outgngChar)){
					map.put(outgngChar , map.get(outgngChar) +1);
					if(map.get(outgngChar) == 1 ) match--;
				}
			}
			if(match == map.size()) result.add(i - p.length()+1);
		}
		return result;
	}
}


