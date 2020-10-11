/*
 * #438. Find All Anagrams in a String
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */


/*
 * Time Complexity: O (N + M) -> N - Time to traverse the string 's', M - Time to traverse the string 'p'
 * 
 * Space Complexity: O (M) -> HashMap to store the count of characters in string 'p', where 'M' is the length of string 'p'
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> output = new ArrayList<>();
        
        // #1. Base condition
        // string 'p' cannot be empty, so just checking for string 's'
        if(s.length() == 0){
            return output;
        }
        
        // #2. Create a HashMap
        // character as a key and its frequency in string 'p' as a value
        HashMap<Character, Integer> count = new HashMap<>();
        
        // #3. Traverse through the string 'p' and fill the hashmap
        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        
        // #4. Traverse thorugh the string 's'
        
        // #4.1. Initialize the 'start' and 'end' pointers and 'match' pointer to indicate that we found a substring with anagram in 's'
        int start = 0;
        int end = 0;
        int match = 0;
        
        // #4.2. Traverse string 's' until end pointer goes out of bounds
        while(end < s.length()){
            
            // #4.2.1. Incoming characters
            char ch_end = s.charAt(end);
            
            // Check if character exists in the map, if yes decrement the count
            if(count.containsKey(ch_end)){
                count.put(ch_end, count.get(ch_end) - 1);
                
                // If count of character is 0, increment match value, means we found a character of an anagram in string 'p'
                if(count.get(ch_end) == 0){
                    match += 1;
                }
            
            }
            
            
            // #4.4.2. Outgoing characters
            // If the length of current substring becomes greater than the anagram's length in string 'p'
            if((end - start) + 1 > p.length()){
                
                // Before incrementing 'start' pointer, get the character at 'start'
                char ch_start = s.charAt(start);
                
                // If map contains that character, increment its count indicating that we need 1 character at current 'start' pointer
                // to get a valid anagram, after incrementing 'start' pointer
                if(count.containsKey(ch_start)){
                    count.put(ch_start, count.get(ch_start) + 1);
                    
                    // After incrementing chraacter count, if it is 1, decrement match value
                    if(count.get(ch_start) == 1){
                        match -= 1;
                    }
                }
                // After reseting map and updating 'match' value if needed, increment 'start' pointer
                start++;
                
            }
            
            // #4.2.3. Check if 'match' value and size of a map are equal, if yes we found our valid anagram in a current substring in 's'
            // Add the index of 'start' pointer to output list
            if(match == count.size()){
                output.add(start);
            }
            
            // #4.2.4. After computing above if conditions, increment the 'end' pointer
            end++;
            
        }
        
        // #5. return the output list
        return output; 
        
    }
    
}
