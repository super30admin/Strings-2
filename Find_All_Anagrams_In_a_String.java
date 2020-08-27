import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	//Approach: Sliding Window
	//1. hashmap will hold the occurrence of character in p with their frequencies. iterate over s with pointer i and have sliding window of size i - p.length()
	//2. for an incoming character, we update the frequencies in map and match - will be updated if we find a single character of p, in the window. 
	//3. for outgoing character, we update the map value by increasing 1, and decrement the match by 1 since char is going out of the window.
	//4. whenever match is equal to the map size, we have found the window of anagram and will add to result list. 
    public List<Integer> findAnagrams(String s, String p) {
        if( p == null || p.length() == 0)
            return null;
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0; 
        //iterate over p and populate map
        for(int i=0;i<p.length();i++)
        {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        //iterate over s and find anagrams with sliding window
        for(int i=0;i<s.length();i++)
        {
            //incoming character
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int count = map.get(in);
                count--;
                if(count == 0)
                    match++;
                map.put(in, count);
            }
            //outgoing character
            if(i >= p.length())
            {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    if(count == 1)
                        match--;
                    map.put(out, count);                    
                }
            }
            if(match == map.size())
                list.add(i-p.length()+1);
        }
        return list;
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(1) since we use hashmap of 26 entries
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Brute force - Test cases passed but took long so couldnt submit in leetcode
class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        if( p == null || p.length() == 0)
            return null;
        List<Integer> list = new ArrayList<>();
    
        //iterate s to find anagrams
        for(int j=0;j <= s.length()-p.length();j++)
        {
            int temp = p.length();
            if(anagramCheck(s.substring(j, j+temp), p))
            {
                list.add(j);
            }
        }
        return list;
        
    }
    private boolean anagramCheck(String str, String p)
    {
        char[] sArray = str.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(pArray);
        for(int i = 0;i<str.length();i++)
        {
            if(sArray[i] != pArray[i])
                return false;
        }
        return true;
    }
}
//Time Complexity : O(m * n log n) 
//Space Complexity : O(p) p -length of char array
//Did this code successfully run on Leetcode : No not able to submit it
//Any problem you faced while coding this :