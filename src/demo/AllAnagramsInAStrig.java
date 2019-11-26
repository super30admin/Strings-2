package demo;

import java.util.*;

public class AllAnagramsInAStrig {
	 List<Integer> ans = new ArrayList<>();
	 Map<Character,Integer> map = new HashMap<Character, Integer>();
		    
		    public List<Integer> findAnagrams(String s, String p) {
		        if(s.length() == 0 || s == null || p.length() ==0 || p == null) return ans;
		        
		        for(int i=0 ; i < p.length(); i++){
		            char c = p.charAt(i);
		            
		            if(!map.containsKey(c)){
		                map.put(c,i);
		            }else{
		                map.put(c, map.get(c)+1);
		            }
		        }
		        
		        
		        return ans;
		    }
}
