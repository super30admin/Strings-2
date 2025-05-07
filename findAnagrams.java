// Time: O(n), Space: O(1) — assuming only lowercase letters

/*
    1. Create a frequency map for string `p`.
    2. Use a sliding window of length `p` to compare against the map.
    3. Add the starting index to result if window matches the frequency map.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams {
    public List<Integer> Anagrams(String s, String p) {

        char[] ref = p.toCharArray();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : ref) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Integer> op = new ArrayList<>();
        int len = ref.length;
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 0;
        int remove = 0;
        HashMap<Character, Integer> check = new HashMap<>();

        while (i < ch.length) {
            while (j != len && i < ch.length) {
                check.put(ch[i], check.getOrDefault(ch[i], 0) + 1);
                j++;
                i++;
            }
            if (check.equals(freq)) {
                op.add(remove);
            }
            int get = check.get(ch[remove]);
            if (get - 1 == 0) {
                check.remove(ch[remove]);
            } else {
                check.put(ch[remove], get - 1);
            }
            j--;
            remove++;
        }

        return op;
    }
}

