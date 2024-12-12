/*
 * TC - O(m+n)
 * SC - O(1)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams{
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: p.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        int match = 0;
        int m = s.length();
        int n = p.length();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(freq.containsKey(in)){
                int count = freq.get(in);
                count--;
                freq.put(in, count);
                if(count == 0){
                    match++;
                }
                //optional 
                // else if(count < 0){
                //     match--; //extra chars 
                // }
            }

            //we have reached the window size 
            if(i >= n){
                char out = s.charAt(i-n); //start of the window 
                if(freq.containsKey(out)){
                    int count = freq.get(out);
                    count++;
                    freq.put(out,count);
                    if(count == 1){
                        match--;
                    }
                    //optional
                    // else if(count <= 0){
                    //     match++;
                    // }
                }
            }

            if(match == freq.size()){
                //found all the elements
                result.add(i-n+1); //get start element 
            }

        }
        return result; 
    }
}