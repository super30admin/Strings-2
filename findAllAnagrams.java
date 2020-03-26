// Time Complexity : O(P+s) iterate over both the strings
// Space Complexity : O(1) because arrays are constant of 26 characters        
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//use two pointers to maintain window in s.
//use array to store count for the string and array.
//compare the windowarray with string count array.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
 
        //need a list for returning result
        List<Integer> res = new ArrayList<>();
        
        //array to store s frequency
        int[] freqWindow = new int[26];
        
        //array to store p frequency
        int[] freqP = new int[26];
        
        //two pointers for mainiting window in s
        int start = 0, end = 0;
        
        //populate freqP
        for(char ch: p.toCharArray()){
            int index = ch - 'a';
            freqP[index]++;
        }
        
        //populate window array
        while(end < s.length()){
            char ch = s.charAt(end);
            freqWindow[ch - 'a']++;
            
            if(end - start + 1 > p.length()){
                freqWindow[s.charAt(start) - 'a']--;
                start++;   
            }
            
            if(Arrays.equals(freqP, freqWindow)){
                res.add(start);
            }
            
            end++;
        }
        
        return res;
    }
}