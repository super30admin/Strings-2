import java.util.*;
public class AllAnagrams{
    //using HashMap
    /**
     * Time Complexity : O(m+n) where n is the length of the string 1 and m is the length of string 2
     * Space Complexity : O(1)
     */
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(p == null || p.length() == 0){return result;}
        HashMap<Character, Integer> store = new HashMap<>();                                                
        for(int c = 0; c < p.length(); c++){
            store.put(p.charAt(c), store.getOrDefault(p.charAt(c), 0) + 1);                                         
        }
        int match = 0;                                                                      
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(store.containsKey(c)){
                    store.put(c, store.get(c)-1);                                          
                    if(store.get(c) == 0)  
                        match++;                                                 
                }
            if(j >= p.length()){
                 char chr = s.charAt(j-p.length());                                         
                 if(store.containsKey(chr)){
                    store.put(chr, store.get(chr)+1);                                      
                    if(store.get(chr) == 1)
                        match--;                                                            
                }
            }
            if(store.size() == match){result.add(j-p.length()+1);}                                  
               }
            return result;
    }

    //Using Intege Arrays
    /**
     * Time Complexity : O(m+n) where n is the length of the string 1 and m is the length of string 2
     * Space Complexity : O(1)
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p == null || p.length() == 0){return result;}
        int[] mapChar = new int[26];                                                        
        for(int c = 0; c < p.length(); c++){
            mapChar[p.charAt(c) - 'a']++;                                               
        }
        int start=0, end =0;
        while(end < s.length()){
            if(mapChar[s.charAt(end) - 'a'] > 0){                                                       
                mapChar[s.charAt(end) - 'a']--;
                end++;                                                                      
            if(end-start == p.length()){                                                        
             result.add(start);                                                     
            }
            }
            else
            if(start == end){                                                       
                start++;
                end++;
            }
            else 
            {
                mapChar[s.charAt(start++) - 'a']++;                                           
            }
        }
            return result;
        }

}
