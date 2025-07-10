import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Approach Hashmap
Time Complexity - O(M + N)
Space Complexity - O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class FindAllAnagramsInString_LC_438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || s.length() == 0 || p.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< p.length(); i++) { //Build map with P frequency
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) +1);
        }
        int match = 0;
        //iterate over s string
        for (int i = 0; i< s.length(); i++) {
            //incoming char
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch); // a= 1 b= 1 c=1
                count--;
                map.put(ch,count);
                if(count == 0) match++;
            }
            //outgoing
            if(i >= p.length()) { //becasue our outgoing element will start from p length onwards
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1) match--;
                }
            }
            if(match == map.size()) {
                result.add(i-p.length() +1);
            }
        }
        return result;
    }
}