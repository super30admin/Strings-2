import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    //tc : O(m + n)
    //sc : O(m)
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || s == null || p.length() == 0 || p == null) return list;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int out = 0;
        int match = 0;

        for (int in = 0; in < s.length(); in++) {
            char ch = s.charAt(in);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                count--;
                map.put(ch, count);
                if (count == 0) match++;

            }

            if (in - out  >= p.length()) {
                char c = s.charAt(out);
                if (map.containsKey(c)) {
                    int count = map.get(c);
                    count++;
                    map.put(c, count);
                    if (count == 1) match--;
                }
                out++;

            }
            if (match == map.size()) list.add(out);
        }
        return list;
    }
    //tc : O(n*(mlogm)); m = len of p; n = len of s
    //sc : O(m)
    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || s == null || p.length() == 0 || p == null) return list;

        char[] temp = p.toCharArray();
        Arrays.sort(temp);
        String pNew = String.valueOf(temp);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + p.length());
            char[] ch = sub.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if (str.equals(pNew)) {
                list.add(i);
            }
        }
        return list;
    }
}
