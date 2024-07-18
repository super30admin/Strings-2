import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.isEmpty() || p.isEmpty()) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        int match = 0;

        for(int i=0; i<p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }

        for(int i=0; i<s.length(); i++) {
            if(i - p.length() >= 0) {
                char outgoing = s.charAt(i - p.length());
                if(map.containsKey(outgoing)) {
                    map.put(outgoing, map.get(outgoing)+1);
                    if(map.get(outgoing) == 1) {
                        match--;
                    }
                }
            }
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)) {
                map.put(incoming, map.get(incoming)-1);
                if(map.get(incoming) == 0) {
                    match++;
                }
                if(match == map.size()) {
                    result.add(i - p.length() + 1);
                }
            }
        }

        return result;
    }
}
