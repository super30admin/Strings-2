import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Time Complexity : O(n) because only one traversal
//Space Complexity : O(1) map size would be constant					
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :
public class AllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
       
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> freqMap = new HashMap<>();
        // prepare map of P character and frequency 
        for(char c : p.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        // variable to track if found all match of p in s 
       int match=0;
       for(int i=0;i<s.length();i++){
           
           char incoming = s.charAt(i);
           if(freqMap.containsKey(incoming)){
                freqMap.put(incoming,freqMap.get(incoming)-1);
                if(freqMap.get(incoming)==0)
                              match++;
                 }    
            if(i >= p.length()){
               char outgoing = s.charAt(i-p.length());
                if(freqMap.containsKey(outgoing)){
                freqMap.put(outgoing,freqMap.get(outgoing)+1);
                if(freqMap.get(outgoing)==1)
                     match--; 
                }
             
           }

       if(match==freqMap.size())
           result.add(i-p.length()+1);
        } 
        
         return result;  
       }
     
}
