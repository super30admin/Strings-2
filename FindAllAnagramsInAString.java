import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(p+s)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this:getting started

// Your code here along with comments explaining your approach

public class FindAllAnagramsInAString {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();

            if(s.length() == 0 || s==null) return list;

            //create array to store count of characters
            int[] charCount = new int[26];

            for(char c:p.toCharArray()){
                charCount[c-'a']++;
            }

            //create pointers for sliding window
            int left=0, right=0, count=p.length();

            while(right<s.length()) {
                 //decrement from charCout and inrease right boundary to start looking for anagram
                if (charCount[s.charAt(right++)-'a']-- >= 1) count--;
                //add left index to list when count is 0
                if(count == 0) list.add(left);

                //when window expands to size of anagram, increment left pointer and add character back to charCount array
                if(right-left == p.length() && charCount[s.charAt(left++)-'a']++ >= 0) count++;
            }
            return list;
        }
    }


}
