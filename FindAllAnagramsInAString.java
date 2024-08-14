import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    /*
    Intuition is that in each sliding window on the s string, check if the count of characters is same as that
    of total count of all characters in the p.
     */
    public static List<Integer> findAnagrams(String s, String p) { //O(m+n) T.C, O(n) S.C
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int sl = s.length(); //m
        int pl = p.length(); //n

        for(int i=0; i<pl; i++) { //frequency map of chars in p
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); //O(n) T.C, O(n) S.C
        }

        int match = 0;
        for(int i=0; i<sl; i++) { //O(m) T.C
            //incoming
            char in = s.charAt(i); //incoming char in the window
            if(map.containsKey(in)) { //if the incoming char is present in map i.e., also present in p
                map.put(in, map.get(in) - 1); //reduce the frequency of this char
                if(map.get(in) == 0) { //if the frequency is 0
                    match++; //increment the count of matched characters
                }
            }

            //outgoing
            if(i >= pl) { //once the iteration reaches at least the length of p
                char out = s.charAt(i-pl); //outgoing char is the first one at p spaces ago
                if(map.containsKey(out)) { //if the outgoing char is in the map
                    map.put(out, map.get(out)+1); //increment its frequency
                    if(map.get(out) == 1) { //and if the count becomes positive
                        match--; //reduce the count of matched characters
                    }
                }
            }

            if(match == map.size()) result.add(i-pl+1); //if count of match becomes equal to map size (n),
            // add the starting index to the result list
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "othellolehol";
        String p = "hello";

        System.out.println("Starting indices of all anagrams of " + p + " in " + s + " are: " +
                findAnagrams(s, p));
    }
}