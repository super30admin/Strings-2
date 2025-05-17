import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();

        List<Integer> res = new ArrayList<>();
        if (m < n)
            return res;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int formed = 0;
        int match = map.size();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                int frq = map.get(c);
                frq--;
                map.put(c, frq);

                if (frq == 0) {
                    formed++;
                }
            }

            if (i >= n) {
                c = s.charAt(i - n);
                if (map.containsKey(c)) {
                    int frq = map.get(c);
                    frq++;
                    map.put(c, frq);
                    if (frq == 1) {
                        formed--;
                    }
                }
            }

            if (formed == match) {
                res.add(i - n + 1);
            }

        }

        return res;
    }
}

//TC: O(m+n), SC: O(1)
