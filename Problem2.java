// There are two approches
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Your code here along with comments explaining your approach
// Approach 1: By Comparing two HashMap
//    Here Comparing two hashMap worst case is O(26) = O(1)
// Time Complexity : O(n)
//      n: length of String
//      m: length of Pattern
// Space Complexity : O(2m) = O(m)= O(1)
//      m: length of Pattern
//   For StringMap and PatternMap of size m
//   Since character length max would be 26
class Problem2S1 {

    /** find indices of Anagrams */
    public List<Integer> findAnagrams(String s, String p) {

        // result
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if(s != null && p!= null && s.length() !=0 && p.length() != 0){

            // initialize
            int n = s.length();
            int m = p.length();

            // base case check
            if(n >= m){

                // create map of Pattern and String
                HashMap<Character, Integer> myPatternMap =  new HashMap<>();
                HashMap<Character, Integer> myStringMap =  new HashMap<>();

                // start from zero
                int i=0;

                // iterate pattern length and create two map
                while(i <m){

                    // pattern
                    char pChar = p.charAt(i);
                    myPatternMap.put(pChar, myPatternMap.getOrDefault(pChar, 0)+1);

                    // string
                    char sChar= s.charAt(i);
                    myStringMap.put(sChar, myStringMap.getOrDefault(sChar, 0)+1);
                    i++;
                }

                // start from patten length
                while(i<n){

                    // check if map is equal i.e both have same frequency
                    if(myPatternMap.equals(myStringMap)) // Note this computational heavy check
                        result.add(i-m);
                    // out char is to be removed from StringMap
                    char out = s.charAt(i-m);

                    // in char to be added to StringMap
                    char in = s.charAt(i);

                    // both are not equal
                    if(out != in){

                        // reduce out count
                        myStringMap.put(out, myStringMap.get(out)-1);

                        // if it hits zero, remove
                        if(myStringMap.get(out) == 0)
                            myStringMap.remove(out);
                        // add in char
                        myStringMap.put(in, myStringMap.getOrDefault(in, 0)+1);
                    }

                    // go to next point
                    i++;
                }

                // pattern matches at the end or both have equal length
                if(myPatternMap.equals(myStringMap))
                    result.add(i-m);
                }
            
        }

        // return result
        return result;
    }
}
// Your code here along with comments explaining your approach
// Approach 2: By using single HashMap
// Time Complexity : O(n)
//      n: length of String
//      m: length of Pattern
// Space Complexity : O(2m) = O(m)= O(1)
//      m: length of Pattern
//   For StringMap and PatternMap of size m
//   Since character length, max would be 26
class Problem2S2 {

    /** find indices of anagrams */
    public List<Integer> findAnagrams(String s, String p) {

        // result
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if(s != null && p!= null && s.length() !=0 && p.length() != 0){

            // initilaize
            int n = s.length();
            int m = p.length();

            // base case
            if(n >= m){

                //pattern HashMap
                HashMap<Character, Integer> myPatternMap =  new HashMap<>();

                // Creaet frequency map
                int i=0;
                while(i <m){
                    char pChar = p.charAt(i);
                    myPatternMap.put(pChar, myPatternMap.getOrDefault(pChar, 0)+1);
                    i++;
                }
                
                // initial values
                int hashMapSize = myPatternMap.size();
                int matchCount = 0;
                i = 0;

                // iterate string
                while(i<n){
                    
                    // incoming 
                    char in = s.charAt(i);
                    // present in map reduce its count
                    if(myPatternMap.containsKey(in)){
                        myPatternMap.put(in, myPatternMap.get(in)-1);
                        // count size is Zero
                        if(myPatternMap.get(in) == 0)
                            matchCount++; // increase match count
                    }
                    
                    // outgoing
                    if(i>=m){
                        char out = s.charAt(i-m);
                        // out present in map increase its count
                        if(myPatternMap.containsKey(out)){
                            myPatternMap.put(out, myPatternMap.get(out)+1);

                            // before count was zero so decrease match count
                            if(myPatternMap.get(out) == 1)
                                matchCount--;
                        }
                    }
                    
                    // matched
                    if(matchCount == hashMapSize)
                        result.add(i-m+1);
                    
                    i++;
                }
                
            }
            
        }
        // return result
        return result;
    }
}