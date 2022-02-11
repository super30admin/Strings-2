
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time Complexity : Add : O(n),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        findAnagrams(s,p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        //null case
        if(s == null || s.length()==0 || p.length()>s.length())
            return result;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);  // S.C - O(1)
        }

        int match = 0;

        for(int high=0; high<s.length(); high++){ // T.C - O(N)
            char incoming = s.charAt(high);
            if(map.containsKey(incoming)){
                int count = map.get(incoming);
                count--;
                if(count == 0) // 1-->0
                    match++;
                map.put(incoming, count);


            }
            if(high>=p.length()){
                char outgoing = s.charAt(high-p.length());
                if(map.containsKey(outgoing)){
                    int count = map.get(outgoing);
                    count++;
                    if(count == 1) // 0-->1
                        match--;

                    map.put(outgoing, count);

                }
            }
            if(match == map.size())
                result.add(high-p.length()+1);

        }

        return result;
    }
}

