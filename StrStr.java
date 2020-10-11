/*
 * #28. Implement strStr()
 * 
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

1. 0 <= haystack.length, needle.length <= 5 * 104
2. haystack and needle consist of only lower-case English characters.

 */


/*
 * Time Complexity : O (n + constant) to create LPS array -> constant because we are staying at some characters for long, 'n' is length of needle
 * 					 O (m + constant) to traverse the "haystack" string -> constant because we are staying at some characters for long, 'm' is length of haystack
 * 
 * Space Complexity: O (n) -> LPS array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings2;

public class StrStr {
	public int strStr(String haystack, String needle) {
        
        // #1. Base condition
        if(needle.length() == 0){
            return 0;
        }
        
        // #2. Create an Longest Prefix Suffix array (LPS) to find out the first occurence of needle in haystack
        int[] LPS = calcLPS(needle);  // O (n + constant) to create LPS array -> constant because we are staying at some characters for long
        
        // #3. Initialize two pointers 'i' for haystack and 'j' for needle
        int i = 0;
        int j = 0;
        
        // #4. Traverse through the haystack string
        while(i < haystack.length()){  // O (m + constant) to traverse the "haystack" string -> constant because we are staying at some characters for long
            
            // #5. Get the characters at 'i'th and 'j'th pointers
            char ch_i = haystack.charAt(i);
            char ch_j = needle.charAt(j);
            
            // #6. Case 1:
            if(ch_i == ch_j){
                // Increment both pointers
                i++;
                j++;
            }
            
            // #7. Case 2:
            // not using else if because the 'j' pointer can go out of bounds if case 1 is satisfied multiple times until j is out of bounds and we will end up not entering else if block and checking for out of bounds condition
            if(j == needle.length()){
                return i - j; // return the index/answer
            }
            
            // #8. Case 3:
            // We are having condition 'j > 0' because for j = 0, LPS[-1] will be invalid
            else if(j > 0 && ch_i != ch_j){
                // update 'j' pointer in needle using LPS array
                j = LPS[j-1];
            }
            
            // #9. Case 4.
            // This Case handles condition when j = 0
            else if(j == 0 && ch_i != ch_j){
                // 'j' pointer in needle is at 0th index and characters doesn't match then definitely needle doesn't start with character at current 'i'th pointer, so increment 'i' pointer
                i++;
            }
        }
        
        return -1;
        
    }
    
    public int[] calcLPS(String needle){
        
        int[] LPS = new int[needle.length()];
        
        // #2.1. Both pointers will traverse the "needle" string
        int j = 0;
        int i = 1;
        
        // #2.2. because for character at first index will always have LPS = 0
        LPS[0] = 0; 
        
        // #2.3. Checking for 'i' pointer as it will go out of bounds before 'j'
        while(i < needle.length()){
            
            // #2.3.1. Get the characters at 'i' and 'j' pointers
            char ch_i = needle.charAt(i);
            char ch_j = needle.charAt(j);
            
            // #2.3.2. Case 1:
            if(ch_i == ch_j){
                j++;
                LPS[i] = j;
                i++;
            }
            
            // #2.3.3. Case 2:
            // We are having condition 'j > 0' because for j = 0, LPS[-1] will be invalid
            else if(j > 0 && ch_i != ch_j){
                j = LPS[j-1];
            }
            
            // #2.3.4. Case3:
            // Meaning, after introducing another character 'i' in needle, when 'j' pointer reaches 0th index and still characters at 'i' and 'j' pointers are not equal, then we can say that our LPS for that 'i'th character will be 0
            else if(j == 0 && ch_i != ch_j){
                // Update LPS value for 'i'th character in LPS array
                LPS[i] = 0;
                i++; // then, increment 'i'
            }
        }
        
        return LPS; // return the LPS array created
    }
    
}
